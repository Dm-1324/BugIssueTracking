package com.example.BugIssueTracking.mapper;

import com.example.BugIssueTracking.dto.issue.IssueInputDTO;
import com.example.BugIssueTracking.dto.issue.IssueOutputDTO;
import com.example.BugIssueTracking.entity.Issue;
import com.example.BugIssueTracking.entity.enums.IssueStatus;
import org.springframework.stereotype.Component;

@Component
public class IssueMapper {
    public Issue toEntity(IssueInputDTO inputDTO) {
        return Issue.builder()
                .title(inputDTO.getTitle())
                .description(inputDTO.getDescription())
                .type(inputDTO.getType())
                .priority(inputDTO.getPriority())
                .status(IssueStatus.NEW)
                .build();
    }

    public IssueOutputDTO toOutputDto(Issue issue) {
        return IssueOutputDTO.builder()
                .id(issue.getId())
                .title(issue.getTitle())
                .description(issue.getDescription())
                .status(issue.getStatus())
                .priority(issue.getPriority())
                .type(issue.getType())
                .projectName(issue.getProject().getName())
                .reporterName(issue.getReporter().getName())
                .assigneeName(issue.getAssignee().getName())
                .updatedAt(issue.getUpdatedAt())
                .build();
    }
}
