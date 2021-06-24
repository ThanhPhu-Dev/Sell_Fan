package sellFan.controller;


import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;
import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.User;
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
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/auth/register"})
public class RegisterController extends HttpServlet {

    @Inject
    IUserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
        ResourceBundle mybundle = ResourceBundle.getBundle("message");
        if(req.getParameter("message") != null){
            String value = mybundle.getString(req.getParameter("message"));
            req.setAttribute("message", new String (value.getBytes("ISO-8859-1"), "UTF-8"));
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/auth/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("username");
        String pass = req.getParameter("password");
        try {
            if(userDAO.findByEmail(email) != null){
                resp.sendRedirect(req.getContextPath()+"/auth/register?message=exists_email");
                return;
            }
            User usernew = new User();
            usernew.setEmail(email);
            usernew.setHashedPw(BCrypt.hashpw(pass, BCrypt.gensalt(12)));
            usernew.setFullName(name);
            //usernew.setCode(RandomStringUtils.randomAlphabetic(10));
            User u = userDAO.save(usernew);

            SendMail.sendMailTo(email, "Xác Nhận Đăng Ký", SendMail.formMailRegister(req, u.getId(), u.getCode()));
            System.out.println("thành công");
            String url = req.getContextPath();
            resp.sendRedirect(req.getContextPath()+"/auth");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
