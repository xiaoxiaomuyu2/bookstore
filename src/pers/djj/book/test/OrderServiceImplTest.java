package pers.djj.book.test;

import org.junit.Test;
import pers.djj.book.pojo.Cart;
import pers.djj.book.pojo.CartItem;
import pers.djj.book.service.OrderService;
import pers.djj.book.service.impl.OrderServiceImpl;

import java.math.BigDecimal;

public class OrderServiceImplTest {
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));

        System.out.println("订单号是：" + orderService.createOrder(cart, 1));
    }
}