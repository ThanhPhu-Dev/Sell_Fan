package sellFan.controller.Cart;

import sellFan.dao.iterface.IBillDAO;
import sellFan.dao.iterface.IBillDetailDAO;
import sellFan.dao.iterface.ICartDAO;
import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.Bill;
import sellFan.dto.BillDetail;
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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
    @Inject
    ICartDAO _cartDAO;

    @Inject
    IUserDAO _userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Object user = session.getAttribute("usercurrent");
        int userId = 1;
        User user = _userDAO.findById(userId);
        List<Cart> list = _cartDAO.findByUserId(userId);
        long provisionalPrice = getProvisionalPrice(list);
        req.setAttribute("carts", list);
        req.setAttribute("provisionalPrice", provisionalPrice);
        req.setAttribute("total", provisionalPrice);
        req.setAttribute("customerName", user.getFullName());
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = req.getRequestDispatcher("/views/cart.jsp");
        rd.forward(req, res);
    }


    private long getProvisionalPrice(List<Cart> carts) {
        long result = 0;
        for (Cart cart : carts) {
            result += cart.getCartProduct().getPrice() * cart.getQuantity();
        }
        return result;
    }
}
