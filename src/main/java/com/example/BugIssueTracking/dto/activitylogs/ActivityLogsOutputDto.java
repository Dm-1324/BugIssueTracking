package com.example.BugIssueTracking.dto.activitylogs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLogsOutputDto {
    private Long id;
    private String action;
    private LocalDateTime timeStamp;
}
