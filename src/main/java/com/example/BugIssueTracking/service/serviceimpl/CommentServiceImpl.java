package com.example.BugIssueTracking.service.serviceimpl;

import com.example.BugIssueTracking.dto.comment.CommentInputDTO;
import com.example.BugIssueTracking.dto.comment.CommentOutputDTO;
import com.example.BugIssueTracking.entity.Comment;
import com.example.BugIssueTracking.entity.Issue;
import com.example.BugIssueTracking.entity.User;
import com.example.BugIssueTracking.exception.ResourceNotFoundException;
import com.example.BugIssueTracking.mapper.CommentMapper;
import com.example.BugIssueTracking.repository.CommentRepository;
import com.example.BugIssueTracking.repository.IssueRepository;
import com.example.BugIssueTracking.repository.UserRepository;
import com.example.BugIssueTracking.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentOutputDTO addComment(Long issueId, CommentInputDTO inputDTO) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new ResourceNotFoundException("Issue not found"));

        User author = userRepository.findById(inputDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not Found"));

        Comment comment = commentMapper.toEntity(inputDTO);
        comment.setIssue(issue);
        comment.setAuthor(author);

        return commentMapper.toOutputDto(commentRepository.save(comment));
    }

    @Override
    public List<CommentOutputDTO> getCommentsByIssue(Long issueId) {
        return commentRepository.findByIssueId(issueId)
                .stream()
                .map(commentMapper::toOutputDto)
                .toList();
    }
}
