package org.example.config.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Admin;
import org.example.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        } else {
            return null;
        }
    }

    @GetMapping("SearchById/{id}")
    public ResponseEntity<Admin> searchById(@PathVariable Long id) {
        Admin searchById = adminService.searchById(id);

        if (searchById!=null) {
            return ResponseEntity.ok(searchById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Admin admin) {
        boolean isUpdated = adminService.update(admin);

        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Admin Updated Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed To Update Admin");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(Long id) {
        boolean isDeleted = adminService.delete(id);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Admin Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed To Delete Admin");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Admin>> getAll() {
        List<Admin> all = adminService.getAll();

        if (all==null || all.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(all);
        }


    }

}
