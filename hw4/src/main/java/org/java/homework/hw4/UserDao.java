package org.java.homework.hw4;

import java.util.List;

public interface UserDao {
    void createUser(Long id, String username);
    void updateUser(Long id, String username);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();

}
