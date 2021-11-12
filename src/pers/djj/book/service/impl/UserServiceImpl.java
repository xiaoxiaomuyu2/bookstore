package pers.djj.book.service.impl;

import pers.djj.book.dao.UserDao;
import pers.djj.book.dao.impl.UserDaoImpl;
import pers.djj.book.pojo.User;
import pers.djj.book.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.queryUserByNameAndPassword(username, password);
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByName(username) != null;
    }
}
