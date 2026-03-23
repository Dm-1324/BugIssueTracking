package com.example.BugIssueTracking.mapper;

import com.example.BugIssueTracking.dto.project.ProjectInputDTO;
import com.example.BugIssueTracking.dto.project.ProjectOutputDTO;
import com.example.BugIssueTracking.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public Project toEntity(ProjectInputDTO inputDTO) {
        return Project.builder()
                .name(inputDTO.getName())
                .description(inputDTO.getDescription())
                .build();
    }

    public ProjectOutputDTO toOutputDto(Project project) {
        return ProjectOutputDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .createdAt(project.getCreatedAt())
                .issueCount(project.getIssues() != null ? project.getIssues().size() : 0)
                .build();
    }
}
