package com.shopease.dao;

import com.shopease.Entities.UserRole;
import java.util.List;

public interface UserRoleDAO {
    void saveUserRole(UserRole userRole);
    UserRole getUserRoleById(Long id);
    UserRole getUserRoleByName(String roleName);
    List<UserRole> getAllUserRoles();
    void deleteUserRole(Long id);
}
