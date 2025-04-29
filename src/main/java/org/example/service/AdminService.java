package org.example.service;

import org.example.dto.Admin;

import java.util.List;

public interface AdminService {
    boolean create(Admin admin);
    Admin searchById(Long id);
    boolean update(Admin admin);
    boolean delete(Long id);
    List<Admin> getAll();
}
