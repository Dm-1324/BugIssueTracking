package com.example.BugIssueTracking.mapper;

import com.example.BugIssueTracking.dto.comment.CommentInputDTO;
import com.example.BugIssueTracking.dto.comment.CommentOutputDTO;
import com.example.BugIssueTracking.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public Comment toEntity(CommentInputDTO inputDTO) {
        return Comment.builder()
                .message(inputDTO.getMessage())
                .id(inputDTO.getUserId())
                .build();
    }

    public CommentOutputDTO toOutputDto(Comment comment) {
        return CommentOutputDTO.builder()
                .id(comment.getId())
                .message(comment.getMessage())
                .authorName(comment.getAuthor().getName())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
