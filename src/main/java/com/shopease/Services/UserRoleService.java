package com.shopease.Services;

import com.shopease.Entities.UserRole;
import java.util.List;

public interface UserRoleService {
    void saveUserRole(UserRole userRole);
    UserRole getUserRoleById(Long id);
    List<UserRole> getAllUserRoles();
}
