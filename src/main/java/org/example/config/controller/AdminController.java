package org.example.config.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Admin;
import org.example.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Admin admin) {
        boolean isCreated = adminService.create(admin);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Admin Created Successfully");
        }
        return null;
    }

    @GetMapping("SearchById/{id}")
    public ResponseEntity<Admin> searchById(@PathVariable Long id) {
        Admin searchById = adminService.searchById(id);

        if (searchById!=null) {
            return ResponseEntity.status(HttpStatus.FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
