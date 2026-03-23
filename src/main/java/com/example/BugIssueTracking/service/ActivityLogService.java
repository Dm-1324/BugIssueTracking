package com.example.BugIssueTracking.service;

import com.example.BugIssueTracking.dto.activitylogs.ActivityLogsOutputDto;
import com.example.BugIssueTracking.entity.Issue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityLogService {
    void createLog(Issue issue, String action);

    List<ActivityLogsOutputDto> getHistoryByIssue(Long issueId);
}
