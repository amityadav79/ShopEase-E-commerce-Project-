package com.shopease.Services;

import com.shopease.Entities.User;
import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
