package com.example.BugIssueTracking.controller;

import com.example.BugIssueTracking.dto.project.ProjectInputDTO;
import com.example.BugIssueTracking.dto.project.ProjectOutputDTO;
import com.example.BugIssueTracking.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectOutputDTO> createProject(@Valid @RequestBody ProjectInputDTO dto) {
        return new ResponseEntity<>(projectService.createProject(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectOutputDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PostMapping("/{projectId}/members/{userId}")
    public ResponseEntity<String> addMember(@PathVariable Long projectId, @PathVariable Long userId) {
        projectService.addMemberToProject(projectId, userId);
        return ResponseEntity.ok("User successfully added to project team");
    }
}
