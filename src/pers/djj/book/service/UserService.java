package pers.djj.book.service;

import pers.djj.book.pojo.User;

public interface UserService {
    void registerUser(User user);

    User login(String username, String password);

    boolean existsUsername(String username);
}
