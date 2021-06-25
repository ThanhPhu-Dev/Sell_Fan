package sellFan.controller;

import sellFan.dao.iterface.IBillDAO;
import sellFan.dao.iterface.IBillDetailDAO;
import sellFan.dao.iterface.ICartDAO;
import sellFan.dao.iterface.IProductDAO;
import sellFan.dto.*;

import javax.inject.Inject;
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

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    @Inject
    ICartDAO _cartDAO;

    @Inject
    IBillDAO _billDAO;

    @Inject
    IBillDetailDAO _billDetailDAO;

    @Inject
    IProductDAO _productDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("usercurrent");
        if(user == null) {
            res.sendRedirect(req.getContextPath() + "/auth");
            return;
        }
        User userCurrent = User.class.cast(user);

        req.setCharacterEncoding("UTF-8");
        String fullname = req.getParameter("fullname");
        String phoneNumber = req.getParameter("phone");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String requirement = req.getParameter("requirement");

        Bill bill = new Bill();
        bill.setUser_Id(userCurrent.getId());
        bill.setFull_Name(fullname);
        bill.setGender(gender);
        bill.setPhone_number(phoneNumber);
        bill.setAddress(address);
        bill.setRequirement(requirement);
        List<Cart> carts = _cartDAO.findByUserId(userCurrent.getId());

        int billId = _billDAO.createBill(bill);
        List<BillDetail> details = createBillDetails(billId, carts);
        int total = totalOfBill(details);
        _billDAO.updateTotal(billId, total);
        _cartDAO.clearCart(userCurrent.getId());

        res.sendRedirect(req.getContextPath() + "/home");
    }

    private List<BillDetail> createBillDetails(int billId, List<Cart> carts) {
        List<BillDetail> list = new ArrayList<>();
        for (Cart cart : carts) {
            int total = cart.getQuantity() * cart.getCartProduct().getPrice();
            BillDetail detail = _billDetailDAO.create(billId, cart, total);
            Product product = cart.getCartProduct();
            _productDAO.updateStock(product.getId(), product.getStock() - cart.getQuantity());
            list.add(detail);
        }
        return list;
    }

    private int totalOfBill(List<BillDetail> details) {
        int total = 0;
        for (BillDetail detail : details) {
            total += detail.getTotal();
        }
        return total;
    }
}
