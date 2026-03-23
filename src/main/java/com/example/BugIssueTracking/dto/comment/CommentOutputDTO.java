package com.example.BugIssueTracking.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentOutputDTO {
    private Long id;
    private String message;
    private String authorName;
    private LocalDateTime createdAt;
}
