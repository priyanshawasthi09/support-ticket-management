package com.support.tickets.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.support.tickets.domain.model.TicketPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.group.GroupSequenceProvider;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

/** A PATCH request whose flags distinguish omitted JSON properties from explicit nulls. */
@GroupSequenceProvider(UpdateTicketRequest.ValidationGroups.class)
public class UpdateTicketRequest {
    @NotBlank(message = "title must not be blank", groups = TitleSupplied.class)
    private String title;
    @NotBlank(message = "description must not be blank", groups = DescriptionSupplied.class)
    private String description;
    @NotNull(message = "priority must be LOW, MEDIUM, or HIGH", groups = PrioritySupplied.class)
    private TicketPriority priority;
    private String assignee;
    @JsonIgnore private boolean titlePresent;
    @JsonIgnore private boolean descriptionPresent;
    @JsonIgnore private boolean priorityPresent;
    @JsonIgnore private boolean assigneePresent;

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TicketPriority getPriority() { return priority; }
    public String getAssignee() { return assignee; }
    public boolean isTitlePresent() { return titlePresent; }
    public boolean isDescriptionPresent() { return descriptionPresent; }
    public boolean isPriorityPresent() { return priorityPresent; }
    public boolean isAssigneePresent() { return assigneePresent; }

    @JsonSetter("title")
    public void setTitle(String title) { this.title = title; this.titlePresent = true; }
    @JsonSetter("description")
    public void setDescription(String description) { this.description = description; this.descriptionPresent = true; }
    @JsonSetter("priority")
    public void setPriority(TicketPriority priority) { this.priority = priority; this.priorityPresent = true; }
    @JsonSetter("assignee")
    public void setAssignee(String assignee) { this.assignee = assignee; this.assigneePresent = true; }


    interface TitleSupplied { }
    interface DescriptionSupplied { }
    interface PrioritySupplied { }

    public static class ValidationGroups implements DefaultGroupSequenceProvider<UpdateTicketRequest> {
        @Override
        public List<Class<?>> getValidationGroups(UpdateTicketRequest request) {
            List<Class<?>> groups = new ArrayList<>();
            groups.add(UpdateTicketRequest.class);
            if (request != null && request.titlePresent) groups.add(TitleSupplied.class);
            if (request != null && request.descriptionPresent) groups.add(DescriptionSupplied.class);
            if (request != null && request.priorityPresent) groups.add(PrioritySupplied.class);
            return groups;
        }
    }
}
