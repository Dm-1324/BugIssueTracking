package com.example.BugIssueTracking.service;

import com.example.BugIssueTracking.dto.project.ProjectInputDTO;
import com.example.BugIssueTracking.dto.project.ProjectOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    ProjectOutputDTO createProject(ProjectInputDTO inputDTO);

    List<ProjectOutputDTO> getAllProjects();

    void addMemberToProject(Long projectId, Long userId);

    boolean isUserInProject(Long projectId, Long userId);
}
