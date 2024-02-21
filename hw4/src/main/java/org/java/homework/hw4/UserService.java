package org.java.homework.hw4;

import java.util.List;

public interface UserService {
    void setUserDao(UserDao userDao);
    void createUser(Long id, String username);
    void deleteUser(Long id);
    List<User> selectAllUsers();
    void updateUser(Long id, String username);
    User selectUser(Long id);
}
