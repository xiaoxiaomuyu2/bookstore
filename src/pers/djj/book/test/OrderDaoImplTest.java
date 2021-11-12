package pers.djj.book.test;

import org.junit.Test;
import pers.djj.book.dao.OrderDao;
import pers.djj.book.dao.impl.OrderDaoImpl;
import pers.djj.book.pojo.Order;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234567890", new Date(), new BigDecimal(100), 0, 1));
    }
}