package org.example.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
    private Long id;
    private String username;
    private String password;
}
