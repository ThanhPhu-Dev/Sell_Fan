package sellFan.controller.Cart;

import sellFan.dao.iterface.ICartDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/cart/delete"})
public class DeleteController extends HttpServlet {

    @Inject
    ICartDAO _cartDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Object user = session.getAttribute("usercurrent");
            if (user == null) {
                res.sendRedirect(req.getContextPath() + "/auth");
                return;
            }

            int cartId = Integer.parseInt(req.getParameter("id"));
            _cartDAO.deleteById(cartId);
            res.sendRedirect(req.getContextPath() + "/cart");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
}
