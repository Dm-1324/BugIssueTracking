package com.example.BugIssueTracking.service.serviceimpl;

import com.example.BugIssueTracking.dto.activitylogs.ActivityLogsOutputDto;
import com.example.BugIssueTracking.entity.ActivityLog;
import com.example.BugIssueTracking.entity.Issue;
import com.example.BugIssueTracking.mapper.ActivityLogMapper;
import com.example.BugIssueTracking.repository.ActivityLogRepository;
import com.example.BugIssueTracking.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogMapper activityLogMapper;
    private final ActivityLogRepository activityLogRepository;

    @Override
    public void createLog(Issue issue, String action) {
        ActivityLog log = ActivityLog.builder()
                .issue(issue)
                .action(action)
                .build();

        activityLogRepository.save(log);

    }

    @Override
    public List<ActivityLogsOutputDto> getHistoryByIssue(Long issueId) {
        return activityLogRepository.findByIssueIdOrderByTimestampDesc(issueId)
                .stream()
                .map(activityLogMapper::toOutputDto)
                .toList();
    }
}
