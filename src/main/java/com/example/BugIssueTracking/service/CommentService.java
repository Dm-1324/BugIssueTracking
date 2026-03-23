package com.example.BugIssueTracking.service;

import com.example.BugIssueTracking.dto.comment.CommentInputDTO;
import com.example.BugIssueTracking.dto.comment.CommentOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    CommentOutputDTO addComment(Long issueId, CommentInputDTO inputDTO);

    List<CommentOutputDTO> getCommentsByIssue(Long issueId);
}
