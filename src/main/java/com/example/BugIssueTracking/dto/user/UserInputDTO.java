package com.example.BugIssueTracking.dto.user;

import com.example.BugIssueTracking.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInputDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Role is required")
    private Role role;
}
