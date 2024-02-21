package org.java.homework.hw4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

public class App 
{
    public static void main( String[] args ) throws EmptyResultDataAccessException
    {
        ApplicationContext context = new AnnotationConfigApplicationContext("org/java/homework/hw4");
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.createUser(1L,"user0");
        userService.createUser(2L,"user1");
        userService.createUser(3L,"user2");
        userService.createUser(4L,"user3");
        userService.selectAllUsers();
        userService.deleteUser(2L);
        userService.selectAllUsers();
        userService.updateUser(3L,"user5");
        userService.selectAllUsers();
        userService.selectUser(1L);
        userService.selectUser(11L);
        for (int i = 1; i <= 4; i++) {
            userService.deleteUser((long) i);
        }
        userService.selectAllUsers();
    }
}
