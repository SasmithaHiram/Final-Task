package org.example.dto;

import lombok.*;
import org.example.util.Department;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Long id;
    private String name;
    private String email;
    private Department department;
}
