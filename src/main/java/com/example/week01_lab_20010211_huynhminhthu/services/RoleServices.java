package com.example.week01_lab_20010211_huynhminhthu.services;

import com.example.week01_lab_20010211_huynhminhthu.models.Role;
import com.example.week01_lab_20010211_huynhminhthu.repositories.RoleRepository;

import java.util.List;

public class RoleServices {
    private static RoleRepository RoleDao = new RoleRepository();

    public static void insertRole(Role role) {
        RoleDao.insertRole(role);
    }

    public static List<Role> getRoles() {
        return RoleDao.getRoles();
    }
}