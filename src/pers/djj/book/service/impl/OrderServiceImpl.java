package pers.djj.book.service.impl;

import pers.djj.book.dao.BookDao;
import pers.djj.book.dao.OrderDao;
import pers.djj.book.dao.OrderItemDao;
import pers.djj.book.dao.impl.BookDaoImpl;
import pers.djj.book.dao.impl.OrderDaoImpl;
import pers.djj.book.dao.impl.OrderItemDaoImpl;
import pers.djj.book.pojo.Book;
import pers.djj.book.pojo.Cart;
import pers.djj.book.pojo.CartItem;
import pers.djj.book.pojo.Order;
import pers.djj.book.pojo.OrderItem;
import pers.djj.book.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);


        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new
                    OrderItem(null, cartItem.getName(), cartItem.getCount(),
                    cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);

//            int error = 1 / 0;

            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();
        return orderId;
    }
}
