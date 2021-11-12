package pers.djj.book.test;

import pers.djj.book.dao.UserDao;
import pers.djj.book.dao.impl.UserDaoImpl;
import pers.djj.book.pojo.User;
import org.junit.Test;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByName() {
        System.out.println(userDao.queryUserByName("admin"));
        System.out.println(userDao.queryUserByName("xxxxx"));
    }

    @Test
    public void queryUserByNameAndPassword() {
        System.out.println(userDao.queryUserByNameAndPassword("admin", "admin"));
        System.out.println(userDao.queryUserByNameAndPassword("xxxxx", "admin"));
        System.out.println(userDao.queryUserByNameAndPassword("admin", "xxxxx"));
    }

    @Test
    public void saveUser() {
        User user = new User(null, "djj", "djjPassword", "djj@qq.com");
        System.out.println(userDao.saveUser(user));
    }
}