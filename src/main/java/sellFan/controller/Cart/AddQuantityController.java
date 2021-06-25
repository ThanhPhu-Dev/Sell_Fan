package sellFan.controller.Cart;

import sellFan.dao.iterface.ICartDAO;
import sellFan.dto.Cart;
import sellFan.dto.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cart/add"})
public class AddQuantityController extends HttpServlet {
    @Inject
    ICartDAO _cartDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int cartId = Integer.parseInt(req.getParameter("id"));
            Cart cart = _cartDAO.findByCartId(cartId);
            if(cart != null) {
                int quantity = cart.getQuantity();
                _cartDAO.updateQuantity(cartId, quantity + 1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            res.sendRedirect(req.getContextPath() + "/cart");
        }
    }
}
