package com.support.tickets.domain.repository;

import com.support.tickets.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> { }
