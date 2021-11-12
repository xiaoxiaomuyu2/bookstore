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

public class ClientBookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

    private void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(System.getProperty("java.specification.version"));
//        System.out.println("ClientBookServlet is visited!");
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.DEFAULT_SIZE);

        Page<Book> page = bookService.getPage(pageNumber, pageSize);
        page.setUrl("client/bookServlet?action=page");

        req.setAttribute("page", page);

//        System.out.println(page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    private void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.DEFAULT_SIZE);
        int minPrice = WebUtils.parseInt(req.getParameter("min"), 0);
        int maxPrice = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        Page<Book> page = bookService.getPageByPrice(pageNumber, pageSize, minPrice, maxPrice);
        StringBuilder url = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min") != null) {
            url.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            url.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(url.toString());


        req.setAttribute("page", page);

//        System.out.println(page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
