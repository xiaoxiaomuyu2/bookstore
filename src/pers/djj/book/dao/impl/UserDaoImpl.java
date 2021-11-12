package pers.djj.book.dao.impl;

import pers.djj.book.dao.UserDao;
import pers.djj.book.pojo.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User queryUserByName(String username) {
        String sql = "select id, username, password, email from t_user where username=?";
        return queryForOne(sql, username);
    }

    @Override
    public User queryUserByNameAndPassword(String username, String password) {
        String sql = "select id, username, password, email from t_user where username = ? and password = ?";
        return queryForOne(sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, password, email) values(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
