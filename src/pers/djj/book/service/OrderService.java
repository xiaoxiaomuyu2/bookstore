package pers.djj.book.service;

import pers.djj.book.pojo.Cart;

public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
