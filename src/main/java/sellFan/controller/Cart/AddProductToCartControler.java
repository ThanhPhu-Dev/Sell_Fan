package sellFan.controller.Cart;

import sellFan.dao.iterface.ICartDAO;
import sellFan.dto.Cart;

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
import sellFan.dto.User;

@WebServlet(urlPatterns = {"/addtocart"})
public class AddProductToCartControler extends HttpServlet {

    @Inject
    ICartDAO _cartDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            //Get user current
            HttpSession session = req.getSession();
            Object user = session.getAttribute("usercurrent");
            if (user == null) {
                res.sendRedirect(req.getContextPath() + "/auth");
                return;
            }
            User userCurrent = User.class.cast(user);

            int productId = Integer.parseInt(req.getParameter("id"));
            Cart cart = _cartDAO.findByProductId(productId);
            if (cart != null) {
                int quantity = cart.getQuantity();
                _cartDAO.updateQuantity(cart.getId(), quantity + 1);
            } else {
                _cartDAO.addCart(productId, userCurrent.getId());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            res.sendRedirect(req.getContextPath() + "/cart");
        }
    }
}
