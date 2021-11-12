package pers.djj.book.dao;

import pers.djj.book.pojo.User;

public interface UserDao {
    User queryUserByName(String username);

    User queryUserByNameAndPassword(String username, String password);

    int saveUser(User user);
}
