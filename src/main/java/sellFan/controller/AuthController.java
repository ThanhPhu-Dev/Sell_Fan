package sellFan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/auth" })
public class AuthController extends HttpServlet {

	private static final long serialVersionUID = -5866282446898633441L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		switch (action) {
		case "login":
			rd = req.getRequestDispatcher("/views/auth/login.jsp");
			break;
		case "register":
			rd = req.getRequestDispatcher("/views/auth/register.jsp");
			break;
		default:
			break;
		}

		rd.forward(req, resp);
	}
}
