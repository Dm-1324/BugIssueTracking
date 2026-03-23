package com.example.BugIssueTracking.service.serviceimpl;

import com.example.BugIssueTracking.dto.issue.IssueInputDTO;
import com.example.BugIssueTracking.dto.issue.IssueOutputDTO;
import com.example.BugIssueTracking.entity.Issue;
import com.example.BugIssueTracking.entity.Project;
import com.example.BugIssueTracking.entity.User;
import com.example.BugIssueTracking.entity.enums.IssueStatus;
import com.example.BugIssueTracking.mapper.IssueMapper;
import com.example.BugIssueTracking.repository.IssueRepository;
import com.example.BugIssueTracking.repository.ProjectRepository;
import com.example.BugIssueTracking.repository.UserRepository;
import com.example.BugIssueTracking.service.ActivityLogService;
import com.example.BugIssueTracking.service.IssueService;
import com.example.BugIssueTracking.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ActivityLogService activityLogService;
    private final ProjectService projectService;
    private final IssueMapper issueMapper;

    @Override
    @Transactional
    public IssueOutputDTO createIssue(Long projectId, IssueInputDTO inputDTO) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project Not Found"));

        User reporter = userRepository.findById(inputDTO.getReporterId())
                .orElseThrow(() -> new RuntimeException("Reporter not found"));

        Issue issue = issueMapper.toEntity(inputDTO);
        issue.setProject(project);
        issue.setReporter(reporter);

        Issue savedIssue = issueRepository.save(issue);

        activityLogService.createLog(issue, "Issue created by " + reporter.getName());

        return issueMapper.toOutputDto(savedIssue);
    }

    @Override
    @Transactional
    public IssueOutputDTO updateStatus(Long issueId, IssueStatus issueStatus) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        String logMessage = "Status changed from " + issue.getStatus() + " to " + issueStatus;
        issue.setStatus(issueStatus);

        Issue updatedIssue = issueRepository.save(issue);
        activityLogService.createLog(updatedIssue, logMessage);

        return issueMapper.toOutputDto(updatedIssue);
    }

    @Override
    @Transactional
    public IssueOutputDTO assignUser(Long issueId, Long userId) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        User assignee = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Assignee not Found"));

        if (!projectService.isUserInProject(issue.getProject().getId(), assignee.getId())) {
            throw new RuntimeException("User is not a member of this project");
        } else {
            issue.setAssignee(assignee);
        }
        activityLogService.createLog(issue, "Assigned to " + assignee.getName());

        return issueMapper.toOutputDto(issueRepository.save(issue));
    }

    @Override
    public List<IssueOutputDTO> getIssueByProject(Long projectId) {
        return issueRepository.findByProjectId(projectId).stream()
                .map(issueMapper::toOutputDto)
                .toList();
    }
}
