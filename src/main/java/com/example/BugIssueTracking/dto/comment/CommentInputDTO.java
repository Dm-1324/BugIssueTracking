package com.example.BugIssueTracking.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentInputDTO {
    @NotBlank(message = "Message cannot be empty")
    private String message;

    @NotNull(message = "User ID is required")
    private Long userId;
}
