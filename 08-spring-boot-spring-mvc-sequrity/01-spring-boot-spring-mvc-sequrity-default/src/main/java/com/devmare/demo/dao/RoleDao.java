package com.devmare.demo.dao;


import com.devmare.demo.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String roleName);
}
