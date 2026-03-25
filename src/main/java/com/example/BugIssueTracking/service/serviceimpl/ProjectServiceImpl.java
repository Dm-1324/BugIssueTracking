package com.example.BugIssueTracking.service.serviceimpl;

import com.example.BugIssueTracking.dto.project.ProjectInputDTO;
import com.example.BugIssueTracking.dto.project.ProjectOutputDTO;
import com.example.BugIssueTracking.entity.Project;
import com.example.BugIssueTracking.entity.User;
import com.example.BugIssueTracking.exception.ResourceNotFoundException;
import com.example.BugIssueTracking.mapper.ProjectMapper;
import com.example.BugIssueTracking.repository.ProjectRepository;
import com.example.BugIssueTracking.repository.UserRepository;
import com.example.BugIssueTracking.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final UserRepository userRepository;

    @Override
    public ProjectOutputDTO createProject(ProjectInputDTO inputDTO) {
        Project project = projectMapper.toEntity(inputDTO);
        return projectMapper.toOutputDto(projectRepository.save(project));
    }

    @Override
    public List<ProjectOutputDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toOutputDto)
                .toList();
    }

    @Override
    @Transactional
    public void addMemberToProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        project.getTeamMembers().add(user);
        projectRepository.save(project);

    }

    @Override
    public boolean isUserInProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        return project.getTeamMembers().stream()
                .anyMatch(user -> user.getId().equals(userId));

    }
}
