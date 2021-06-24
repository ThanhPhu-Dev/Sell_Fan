package sellFan.controller;

import org.mindrot.jbcrypt.BCrypt;
import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.User;
import sellFan.utils.MessageUtils;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/auth"})
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = -5866282446898633441L;

	@Inject
    IUserDAO userDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/auth/login.jsp");
		MessageUtils.setMessageToAttribute(req);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		User user = userDAO.findByEmail(email);
		if(user == null){
			resp.sendRedirect(req.getContextPath()+"/auth?message=notExists_email");
			return;
		}else{
			if(BCrypt.checkpw(pass, user.getHashedPw()) == false){
				resp.sendRedirect(req.getContextPath()+"/auth?message=incorrect_password");
				return;
			}else{
				HttpSession session = req.getSession();
				session.setAttribute("usercurrent", user);
				resp.sendRedirect(req.getContextPath()+"/home");
				return;
			}
		}
	}
}
