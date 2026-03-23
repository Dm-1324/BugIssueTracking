package com.example.BugIssueTracking.service;

import com.example.BugIssueTracking.dto.user.UserInputDTO;
import com.example.BugIssueTracking.dto.user.UserOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserOutputDTO createUser(UserInputDTO dto);

    List<UserOutputDTO> getAllUsers();

    UserOutputDTO getUserById(Long id);
}
