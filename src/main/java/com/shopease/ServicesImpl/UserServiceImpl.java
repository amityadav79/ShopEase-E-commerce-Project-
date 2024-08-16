package com.shopease.ServicesImpl;

import com.shopease.dao.UserDAO;
import com.shopease.Entities.User;
import com.shopease.Services.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
