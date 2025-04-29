package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.util.Department;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Long id;
    @NotBlank(message = "Username is required")
    private String name;
    @NotBlank(message = "email is required")
    private Department department;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
