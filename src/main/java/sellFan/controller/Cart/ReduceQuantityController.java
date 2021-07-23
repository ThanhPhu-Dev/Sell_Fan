package sellFan.controller.Cart;

import sellFan.dao.iterface.ICartDAO;
import sellFan.dto.Cart;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/cart/reduce"})
public class ReduceQuantityController extends HttpServlet {

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
            Cart cart = _cartDAO.findByCartId(cartId);
            if (cart != null) {
                int quantity = cart.getQuantity();
                if (quantity > 1) {
                    _cartDAO.updateQuantity(cartId, quantity - 1);
                }
            }

            res.sendRedirect(req.getContextPath() + "/cart");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
}
