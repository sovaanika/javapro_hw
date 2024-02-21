package org.java.homework.hw4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(Long id, String username) {
        userDao.createUser(id, username);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(Long id, String username) {
        userDao.updateUser(id, username);
    }

    @Override
    public User selectUser(Long id) {
        return userDao.getUserById(id);
    }
}
