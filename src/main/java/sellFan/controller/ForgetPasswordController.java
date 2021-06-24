package sellFan.controller;

import org.apache.commons.lang3.RandomStringUtils;
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
import java.io.IOException;

@WebServlet(urlPatterns = {"/auth/forgetpassword"})
public class ForgetPasswordController extends HttpServlet {

    @Inject
    IUserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MessageUtils.setMessageToAttribute(req);
        RequestDispatcher rd = req.getRequestDispatcher("/views/auth/forgetPassword.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User u = userDAO.findByEmail(email);
        if (u != null) {
            try {
                u.setCode(RandomStringUtils.randomAlphabetic(10));
                userDAO.update(u);
                SendMail.sendMailTo(email, "Xác Nhận Quên Mật Khẩu", SendMail.formMailRegister(req, u.getId(), u.getCode()));
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            resp.sendRedirect(req.getContextPath() + "/auth/forgetpassword?message=success_sendMain_email");
            return;
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/forgetpassword?message=notExists_email");
            return;
        }
    }
}
