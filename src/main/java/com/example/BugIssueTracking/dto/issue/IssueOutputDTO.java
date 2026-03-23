package com.example.BugIssueTracking.dto.issue;

import com.example.BugIssueTracking.entity.enums.IssueStatus;
import com.example.BugIssueTracking.entity.enums.IssueType;
import com.example.BugIssueTracking.entity.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueOutputDTO {
    private Long id;
    private String title;
    private String description;
    private IssueStatus status;
    private Priority priority;
    private IssueType type;
    private String projectName;
    private String reporterName;
    private String assigneeName;
    private LocalDateTime updatedAt;
}
