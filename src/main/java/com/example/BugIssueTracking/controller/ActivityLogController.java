package com.example.BugIssueTracking.controller;

import com.example.BugIssueTracking.dto.activitylogs.ActivityLogsOutputDto;
import com.example.BugIssueTracking.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/issues/{issueId}/history")
@RequiredArgsConstructor
public class ActivityLogController {
    private final ActivityLogService activityLogService;

    @GetMapping
    public ResponseEntity<List<ActivityLogsOutputDto>> getHistory(@PathVariable Long issueId) {
        return ResponseEntity.ok(activityLogService.getHistoryByIssue(issueId));
    }
}