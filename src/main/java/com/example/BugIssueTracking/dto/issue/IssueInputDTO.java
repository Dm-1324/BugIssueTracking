package com.example.BugIssueTracking.dto.issue;

import com.example.BugIssueTracking.entity.enums.IssueType;
import com.example.BugIssueTracking.entity.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueInputDTO {
    @NotBlank(message = "Title is required")
    private String title;
    
    private String description;

    @NotNull(message = "Type is required")
    private IssueType type;

    @NotNull(message = "Priority is required")
    private Priority priority;

    @NotNull(message = "Reporter ID is required")
    private Long reporterId;

    private Long assigneeId;
}
