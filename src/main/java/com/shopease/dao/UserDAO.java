package com.shopease.dao;

import com.shopease.Entities.User;
import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByUsername(String username);  // This method was missing
    List<User> getAllUsers();
    void deleteUser(Long id);
}
