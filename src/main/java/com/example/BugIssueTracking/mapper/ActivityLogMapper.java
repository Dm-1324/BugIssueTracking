package com.example.BugIssueTracking.mapper;

import com.example.BugIssueTracking.dto.activitylogs.ActivityLogsOutputDto;
import com.example.BugIssueTracking.entity.ActivityLog;
import org.springframework.stereotype.Component;

@Component
public class ActivityLogMapper {
    public ActivityLogsOutputDto toOutputDto(ActivityLog activityLog) {
        return ActivityLogsOutputDto.builder()
                .id(activityLog.getId())
                .action(activityLog.getAction())
                .timeStamp(activityLog.getTimestamp())
                .build();
    }
}
