package sellFan.controller.Cart;

import sellFan.dao.iterface.ICartDAO;
import sellFan.dao.iterface.IProductDAO;
import sellFan.dto.Cart;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart/add"})
public class AddQuantityController extends HttpServlet {

    @Inject
    ICartDAO _cartDAO;

    @Inject
    IProductDAO _productDAO;

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
            int stock = _productDAO.getProductById(cart.getProductId()).getStock();
            int quantity = cart.getQuantity();

            if (cart != null && quantity < stock) {
                _cartDAO.updateQuantity(cartId, quantity + 1);
            }

            res.sendRedirect(req.getContextPath() + "/cart");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
}
