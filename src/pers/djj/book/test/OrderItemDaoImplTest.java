package pers.djj.book.test;

import org.junit.Test;
import pers.djj.book.dao.OrderItemDao;
import pers.djj.book.dao.impl.OrderItemDaoImpl;
import pers.djj.book.pojo.OrderItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null, "java 从入门到精通", 1, new BigDecimal(100),
                new BigDecimal(100), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javaScript 从入门到精通", 2,
                new BigDecimal(100), new BigDecimal(200), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "Netty 入门", 1, new BigDecimal(100),
                new BigDecimal(100), "1234567890"));
    }
}