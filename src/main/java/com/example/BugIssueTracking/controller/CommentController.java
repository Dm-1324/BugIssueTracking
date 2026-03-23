package com.example.BugIssueTracking.controller;

import com.example.BugIssueTracking.dto.comment.CommentInputDTO;
import com.example.BugIssueTracking.dto.comment.CommentOutputDTO;
import com.example.BugIssueTracking.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues/{issueId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentOutputDTO> addComment(
            @PathVariable Long issueId,
            @Valid @RequestBody CommentInputDTO dto) {
        return new ResponseEntity<>(commentService.addComment(issueId, dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentOutputDTO>> getComments(@PathVariable Long issueId) {
        return ResponseEntity.ok(commentService.getCommentsByIssue(issueId));
    }
}
