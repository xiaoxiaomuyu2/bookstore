package pers.djj.book.web;

import pers.djj.book.pojo.Book;
import pers.djj.book.pojo.Cart;
import pers.djj.book.pojo.CartItem;
import pers.djj.book.service.BookService;
import pers.djj.book.service.impl.BookServiceImpl;
import pers.djj.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    private void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("bookId"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);
//        System.out.println(cart);

        req.getSession().setAttribute("lastItemName", cartItem.getName());

//        System.err.println(req.getHeader("Referer"));
//        System.err.println(req.getContextPath());
        resp.sendRedirect(WebUtils.getFullReferrerUrl(req));
    }

    private void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
        }
        resp.sendRedirect(WebUtils.getFullReferrerUrl(req));
    }

    private void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        resp.sendRedirect(WebUtils.getFullReferrerUrl(req));
    }

    private void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
        }
        resp.sendRedirect(WebUtils.getFullReferrerUrl(req));
    }
}