package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Admin;

import org.example.entity.AdminEntity;
import org.example.repository.AdminRepository;
import org.example.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    @Override
    public boolean create(Admin admin) {
        if (admin!=null) {
            adminRepository.save(modelMapper.map(admin, AdminEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public Admin searchById(Long id) {
        Admin found = modelMapper.map(adminRepository.findById(id), Admin.class);

        if (found==null) {
            return null;
        } else {
            return found;
        }
    }

    @Override
    public boolean update(Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Admin> getAll() {
        return List.of();
    }
}
