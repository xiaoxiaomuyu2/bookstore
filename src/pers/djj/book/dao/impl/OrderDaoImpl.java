package pers.djj.book.dao.impl;

import pers.djj.book.dao.OrderDao;
import pers.djj.book.pojo.Order;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) " +
                "values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(),
                order.getPrice(), order.getStatus(), order.getUserId());
    }
}
