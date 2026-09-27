#!/usr/bin/env python3
"""
Chat history parser for JetBrains AI Assistant workspace XML files.
Usage:
    python workspace_chat_parser.py <ide_config_or_workspace_or_xml_path>
    python workspace_chat_parser.py ~/Library/Application Support/JetBrains/PyCharm2026.1/workspace

On Windows, AppData\\Local JetBrains product dirs are accepted and mapped to
the matching AppData\\Roaming config/workspace dir.

Saves the full chat history to chat_history.md.
"""

from __future__ import annotations

import argparse
import html
import os
import re
import sys
from dataclasses import dataclass, field
from pathlib import Path
from xml.etree import ElementTree as ET


CHAT_COMPONENT_MARKER = "ChatSessionStateTemp"


# ─────────────────────────── Data classes ───────────────────────────

@dataclass
class Attachment:
    name: str
    text: str | None = None


@dataclass
class Message:
    author: str  # "User" or "Assistant"
    content: str
    attachments: list[Attachment] = field(default_factory=list)


@dataclass
class Chat:
    title: str
    model_id: str
    messages: list[Message] = field(default_factory=list)


# ─────────────────────────── Helpers ────────────────────────────────

def _clean_content(raw: str) -> str:
    """Remove internal progress/log tags and unescape HTML entities."""
    text = re.sub(r"<llm-progress-log-group>.*?</llm-progress-log-group>", "", raw, flags=re.DOTALL)
    text = re.sub(r"<llm-snippet-file>.*?</llm-snippet-file>", "", text, flags=re.DOTALL)
    return html.unescape(text).strip()


def _get_option(element: ET.Element, name: str) -> str | None:
    """Return the 'value' attribute of a direct <option name=...> child."""
    node = element.find(f"./option[@name='{name}']")
    return node.get("value") if node is not None else None


def _expand_path(value: str) -> Path:
    return Path(os.path.expandvars(value)).expanduser()


def _jetbrains_product_dir_from_source(source: Path) -> Path:
    base = source.parent if source.is_file() else source
    current = base
    while current != current.parent:
        if current.parent.name.lower() == "jetbrains":
            return current
        current = current.parent
    return base.parent if base.name.lower() == "workspace" else base


def _is_relative_to(path: Path, parent: Path) -> bool:
    try:
        path.resolve().relative_to(parent.resolve())
        return True
    except ValueError:
        return False


def _config_dir_from_source(source: Path) -> Path:
    product_dir = _jetbrains_product_dir_from_source(source)
    if sys.platform == "win32":
        local = Path(os.environ.get("LOCALAPPDATA", str(Path.home() / "AppData" / "Local"))).expanduser()
        local_jetbrains = local / "JetBrains"
        if _is_relative_to(product_dir, local_jetbrains):
            appdata = Path(os.environ.get("APPDATA", str(Path.home() / "AppData" / "Roaming"))).expanduser()
            return appdata / "JetBrains" / product_dir.name
    return product_dir


def _resolve_workspace_source(source: Path, config_dir: Path) -> Path:
    if source.is_file():
        return source
    if source.name.lower() == "workspace":
        return source

    source_product_dir = _jetbrains_product_dir_from_source(source)
    config_workspace = config_dir / "workspace"
    if config_dir != source_product_dir:
        return config_workspace
    if config_workspace.is_dir():
        return config_workspace

    candidate = source / "workspace"
    return candidate if candidate.is_dir() else source


def _file_mentions_chat_component(path: Path) -> bool:
    try:
        return CHAT_COMPONENT_MARKER in path.read_text(encoding="utf-8", errors="replace")
    except OSError:
        return False


# ─────────────────────────── Parser ─────────────────────────────────

def parse_xml(path: Path) -> list[Chat]:
    try:
        tree = ET.parse(path)
    except ET.ParseError as exc:
        print(f"[WARN] Cannot parse {path}: {exc}", file=sys.stderr)
        return []

    component = tree.getroot().find(".//component[@name='ChatSessionStateTemp']")
    if component is None:
        return []

    chats: list[Chat] = []

    for chat_el in component.findall(".//SerializedChat"):
        uid = _get_option(chat_el, "uid") or ""
        model_id = _get_option(chat_el, "chatModelId") or ""

        title_el = chat_el.find("./option[@name='title']/SerializedChatTitle")
        title = (title_el is not None and _get_option(title_el, "text")) or uid

        chat = Chat(title=title, model_id=model_id)

        for msg_el in chat_el.findall(".//SerializedChatMessage"):
            author = _get_option(msg_el, "author") or "User"

            display = _get_option(msg_el, "displayContent") or ""
            internal = _get_option(msg_el, "internalContent") or ""
            content = _clean_content(display or internal)

            attachments = [
                Attachment(
                    name=_get_option(att_el, "name") or "",
                    text=_clean_content(_get_option(att_el, "text") or ""),
                )
                for att_el in msg_el.findall(".//SerializedChatAttachment")
            ]

            chat.messages.append(Message(author=author, content=content, attachments=attachments))

        chats.append(chat)

    return chats


def parse_path(source: Path) -> list[Chat]:
    """Accept a single XML file or a directory (recursive scan)."""
    if source.is_file():
        return parse_xml(source)

    all_chats: list[Chat] = []
    for xml_file in sorted(source.rglob("*.xml")):
        if not _file_mentions_chat_component(xml_file):
            continue
        found = parse_xml(xml_file)
        if found:
            print(f"[INFO] {xml_file.name}: {len(found)} chat(s)")
            all_chats.extend(found)
    return all_chats


def source_from_args(parts: list[str]) -> Path:
    """Accept both quoted and accidentally unquoted paths with spaces."""
    return _expand_path(" ".join(parts).strip())


# ─────────────────────────── Formatter ──────────────────────────────

def to_markdown(chats: list[Chat]) -> str:
    lines: list[str] = []
    for chat in chats:
        lines.append(f"## {chat.title}")
        lines.append(f"> Model: `{chat.model_id}`  \n")
        for msg in chat.messages:
            if not msg.content and not msg.attachments:
                continue
            role_label = "**Assistant**" if msg.author == "Assistant" else "**User**"
            lines.append(f"### {role_label}")
            if msg.content:
                lines.append(msg.content)
            for att in msg.attachments:
                lines.append(f"\n*Attachment: {att.name}*")
                if att.text:
                    lines.append(f"```\n{att.text}\n```")
            lines.append("")
        lines.append("---\n")
    return "\n".join(lines)


# ─────────────────────────── CLI ────────────────────────────────────

def main():
    ap = argparse.ArgumentParser(
        description="Parse JetBrains AI Assistant chats from a workspace XML file or directory."
    )
    ap.add_argument(
        "source",
        nargs="+",
        help="path to an XML file or workspace directory; unquoted paths with spaces are accepted",
    )
    args = ap.parse_args()

    raw_source = source_from_args(args.source)
    if not raw_source.exists():
        print(f"[ERROR] Path not found: {raw_source}", file=sys.stderr)
        sys.exit(1)

    source_product_dir = _jetbrains_product_dir_from_source(raw_source)
    config_dir = _config_dir_from_source(raw_source)
    source = _resolve_workspace_source(raw_source, config_dir)
    if config_dir != source_product_dir:
        print(f"[INFO] source looks like JetBrains system/cache dir: {source_product_dir}")
        print(f"[INFO] using matching config dir: {config_dir}")
    print(f"[INFO] scanning: {source}")

    if not source.exists():
        print(f"[ERROR] Workspace path not found: {source}", file=sys.stderr)
        if sys.platform == "win32":
            print("[HINT] AI Assistant workspace XML is normally under %APPDATA%\\JetBrains\\<product><version>\\workspace.", file=sys.stderr)
        sys.exit(1)

    chats = parse_path(source)
    if not chats:
        print("[WARN] No chats found.", file=sys.stderr)
        sys.exit(0)

    output = Path("chat_history.md")
    output.write_text(to_markdown(chats), encoding="utf-8")
    print(f"[OK] Written {len(chats)} chat(s) to {output}")


if __name__ == "__main__":
    main()
