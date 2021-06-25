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

@WebServlet(urlPatterns = {"/cart/delete"})
public class DeleteController extends HttpServlet {
    @Inject
    ICartDAO _cartDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int cartId = Integer.parseInt(req.getParameter("id"));
            _cartDAO.deleteById(cartId);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            res.sendRedirect(req.getContextPath() + "/cart");
        }
    }
}
