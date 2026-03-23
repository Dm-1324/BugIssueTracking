package com.example.BugIssueTracking.service;

import com.example.BugIssueTracking.dto.issue.IssueInputDTO;
import com.example.BugIssueTracking.dto.issue.IssueOutputDTO;
import com.example.BugIssueTracking.entity.enums.IssueStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IssueService {
    IssueOutputDTO createIssue(Long projectId, IssueInputDTO inputDTO);

    IssueOutputDTO updateStatus(Long issueId, IssueStatus issueStatus);

    IssueOutputDTO assignUser(Long issueId, Long userId);

    List<IssueOutputDTO> getIssueByProject(Long projectId);
}
