package pers.djj.book.web;

import pers.djj.book.pojo.User;
import pers.djj.book.service.UserService;
import pers.djj.book.service.impl.UserServiceImpl;
import pers.djj.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().setAttribute(KAPTCHA_SESSION_KEY, null);

        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(user.getUsername())) {
                req.setAttribute("msg", "用户名已存在");
                System.out.println("username exists!");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            System.out.println("wrong code!");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(username, password);
        if (user == null) {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            System.out.println("wrong password!");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", user);
            Boolean isAdmin = "admin".equals(user.getUsername());
            System.out.println(isAdmin);
            req.getSession().setAttribute("isAdmin", isAdmin);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("user", null);
        req.getSession().setAttribute("isAdmin", false);
        resp.sendRedirect(req.getContextPath());
    }
}
