package pers.djj.book.test;

import pers.djj.book.pojo.User;
import pers.djj.book.service.UserService;
import pers.djj.book.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        User user = new User(null, "abcName", "abcPassword", "abc@qq.com");
        userService.registerUser(user);
    }

    @Test
    public void login() {
        System.out.println(userService.login("djj", "djjPassword"));
        System.out.println(userService.login("djj", "djj_Password"));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("djj"));
        System.out.println(userService.existsUsername("djj_"));
    }
}