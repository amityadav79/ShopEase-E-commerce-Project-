package com.shopease.ServicesImpl;

import com.shopease.dao.UserRoleDAO;
import com.shopease.Entities.UserRole;
import com.shopease.Services.UserRoleService;
import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleDAO userRoleDAO;

    public UserRoleServiceImpl() {
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public void saveUserRole(UserRole userRole) {
        userRoleDAO.saveUserRole(userRole);
    }

    @Override
    public UserRole getUserRoleById(Long id) {
        return userRoleDAO.getUserRoleById(id);
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleDAO.getAllUserRoles();
    }
}
