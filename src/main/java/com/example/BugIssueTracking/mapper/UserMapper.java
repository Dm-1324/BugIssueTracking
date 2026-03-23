package com.example.BugIssueTracking.mapper;

import com.example.BugIssueTracking.dto.user.UserInputDTO;
import com.example.BugIssueTracking.dto.user.UserOutputDTO;
import com.example.BugIssueTracking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserInputDTO inputDTO) {
        return User.builder()
                .name(inputDTO.getName())
                .email(inputDTO.getEmail())
                .role(inputDTO.getRole())
                .build();
    }

    public UserOutputDTO toOutputDto(User user) {
        return UserOutputDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
