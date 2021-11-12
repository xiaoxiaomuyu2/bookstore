package pers.djj.book.web;

import pers.djj.book.pojo.Book;
import pers.djj.book.pojo.Page;
import pers.djj.book.service.BookService;
import pers.djj.book.service.impl.BookServiceImpl;
import pers.djj.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookService.queryBooks());
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        System.out.println(book);
        bookService.addBook(book);
        resp.sendRedirect(String.format("%s/manager/bookServlet?action=page&pageNumber=%s&pageSize=4",
                req.getContextPath(), req.getParameter("pageNumber")));
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        System.out.println(req.getParameter("id"));
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);

        resp.sendRedirect(String.format("%s/manager/bookServlet?action=page&pageNumber=%s&pageSize=4",
                req.getContextPath(), req.getParameter("pageNumber")));
    }

    private void queryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);

        resp.sendRedirect(String.format("%s/manager/bookServlet?action=page&pageNumber=%s&pageSize=4",
                req.getContextPath(), req.getParameter("pageNumber")));
    }

    private void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.DEFAULT_SIZE);

        Page<Book> page = bookService.getPage(pageNumber, pageSize);
        page.setUrl("manager/bookServlet?action=page");

        req.setAttribute("page", page);

//        System.out.println(page);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
