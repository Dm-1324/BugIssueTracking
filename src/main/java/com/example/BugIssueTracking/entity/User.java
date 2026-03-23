package com.example.BugIssueTracking.entity;

import com.example.BugIssueTracking.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is Required")
    private String name;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "Role is Required")
    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "reporter")
    private List<Issue> reportedIssue;

    @OneToMany(mappedBy = "assignee")
    private List<Issue> assignedIssue;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    @ManyToMany(mappedBy = "teamMembers")
    private List<Project> projects;
}
