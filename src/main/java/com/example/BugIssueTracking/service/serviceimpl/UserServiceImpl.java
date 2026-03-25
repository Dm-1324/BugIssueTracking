package com.example.BugIssueTracking.service.serviceimpl;

import com.example.BugIssueTracking.dto.user.UserInputDTO;
import com.example.BugIssueTracking.dto.user.UserOutputDTO;
import com.example.BugIssueTracking.entity.User;
import com.example.BugIssueTracking.exception.ResourceNotFoundException;
import com.example.BugIssueTracking.mapper.UserMapper;
import com.example.BugIssueTracking.repository.UserRepository;
import com.example.BugIssueTracking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserOutputDTO createUser(UserInputDTO dto) {
        User user = userMapper.toEntity(dto);
        return userMapper.toOutputDto(userRepository.save(user));
    }

    @Override
    public List<UserOutputDTO> getAllUsers() {

        return userRepository.findAll().stream()
                .map(userMapper::toOutputDto).toList();
    }

    @Override
    public UserOutputDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        return userMapper.toOutputDto(user);
    }
}
