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

@WebServlet(urlPatterns = {"/cart/reduce"})
public class ReduceQuantityController extends HttpServlet {
    @Inject
    ICartDAO _cartDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Object user = session.getAttribute("usercurrent");
        try {
            int userId = 1;
            int cartId = Integer.parseInt(req.getParameter("id"));
            Cart cart = _cartDAO.findByCartId(cartId);
            if(cart != null) {
                int quantity = cart.getQuantity();
                if (quantity > 1) {
                    _cartDAO.updateQuantity(cartId, quantity - 1);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            res.sendRedirect(req.getContextPath() + "/cart");
        }
    }
}
