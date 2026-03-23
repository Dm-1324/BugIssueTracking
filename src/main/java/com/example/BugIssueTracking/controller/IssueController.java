package com.example.BugIssueTracking.controller;

import com.example.BugIssueTracking.dto.issue.IssueInputDTO;
import com.example.BugIssueTracking.dto.issue.IssueOutputDTO;
import com.example.BugIssueTracking.entity.enums.IssueStatus;
import com.example.BugIssueTracking.service.IssueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issue")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;

    @PostMapping("/projects/{projectId}/issues")
    public ResponseEntity<IssueOutputDTO> createIssue(
            @PathVariable Long projectId,
            @Valid @RequestBody IssueInputDTO dto) {
        return new ResponseEntity<>(issueService.createIssue(projectId, dto), HttpStatus.CREATED);
    }

    @GetMapping("/projects/{projectId}/issues")
    public ResponseEntity<List<IssueOutputDTO>> getIssuesByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(issueService.getIssueByProject(projectId));
    }

    @PatchMapping("/issues/{id}/status")
    public ResponseEntity<IssueOutputDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam IssueStatus status) {
        return ResponseEntity.ok(issueService.updateStatus(id, status));
    }

    @PatchMapping("/issues/{id}/assign")
    public ResponseEntity<IssueOutputDTO> assignUser(
            @PathVariable Long id,
            @RequestParam Long userId) {
        return ResponseEntity.ok(issueService.assignUser(id, userId));
    }
}
