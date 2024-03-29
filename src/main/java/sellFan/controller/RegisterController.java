package sellFan.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;
import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.User;
import sellFan.utils.MessageUtils;
import sellFan.utils.SendMail;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/auth/register"})
public class RegisterController extends HttpServlet {

    @Inject
    IUserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String id = null;
        String code = null;
        MessageUtils.setMessageToAttribute(req);
        HttpSession session = req.getSession();
        if (req.getParameter("action") != null) {
            id = req.getParameter("id");
            code = req.getParameter("code");
            User u = userDAO.findById(Integer.parseInt(id));
            if (u == null) {
                return;
            }
            if (u.getCode() != null) {
                if (u.getCode().equals(code)) {
                    u.setCode(null);
                    u.setStatus(1);
                    userDAO.update(u);
                    session.setAttribute("usercurrent", u);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        if (session.getAttribute("usercurrent") != null) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/auth/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String email = req.getParameter("email");
        String name = req.getParameter("username");
        String pass = req.getParameter("password");
        try {
            if (userDAO.findByEmail(email) != null) {
                resp.sendRedirect(req.getContextPath() + "/auth/register?message=exists_email&alert=danger");
                return;
            }
            User usernew = new User();
            usernew.setEmail(email);
            usernew.setHashedPw(BCrypt.hashpw(pass, BCrypt.gensalt(12)));
            usernew.setFullName(name);
            usernew.setCode(RandomStringUtils.randomAlphabetic(10));
            User u = userDAO.save(usernew);

            SendMail.sendMailTo(email, "Xác nhận đăng ký", SendMail.formMailRegister(req, u.getId(), u.getCode()));
            resp.sendRedirect(req.getContextPath() + "/auth/register?message=success_sendMain_email&alert=success");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
