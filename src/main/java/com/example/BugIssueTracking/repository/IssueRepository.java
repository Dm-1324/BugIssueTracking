package com.example.BugIssueTracking.repository;

import com.example.BugIssueTracking.entity.Issue;
import com.example.BugIssueTracking.entity.enums.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findByProjectId(Long projectId);

    List<Issue> findByStatus(IssueStatus issueStatus);
}
