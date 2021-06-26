package sellFan.controller;

import org.mindrot.jbcrypt.BCrypt;
import sellFan.dao.impl.UserDAO;
import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.User;
import sellFan.utils.MessageUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/auth/changepassword"})
public class ChangePasswordController extends HttpServlet {

    @Inject
    IUserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String code = req.getParameter("code");

        User u = userDAO.findById(Integer.parseInt(id));
        if(u != null) return;
        if( u.getCode() != null){
            if(u.getCode().equals(code)){
                req.setAttribute("id", id);
                RequestDispatcher rd = req.getRequestDispatcher("/views/auth/changePassword.jsp");
                rd.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pass = req.getParameter("password");
        User u = userDAO.findById(Integer.parseInt(id));
        u.setHashedPw(BCrypt.hashpw(pass, BCrypt.gensalt(12)));
        u.setCode(null);
        userDAO.update(u);
        req.setAttribute("message", "Thay đổi mật khẩu thành công.");
        RequestDispatcher rd = req.getRequestDispatcher("/views/auth/changePassword.jsp");
        rd.forward(req, resp);
    }
}
