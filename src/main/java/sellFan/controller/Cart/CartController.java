package sellFan.controller.Cart;

import sellFan.dao.iterface.IBillDAO;
import sellFan.dao.iterface.IBillDetailDAO;
import sellFan.dao.iterface.ICartDAO;
import sellFan.dto.Bill;
import sellFan.dto.BillDetail;
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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
    @Inject
    ICartDAO _cartDAO;

    @Inject
    IBillDAO _billDAO;

    @Inject
    IBillDetailDAO _billDetailDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Object user = session.getAttribute("usercurrent");
        int userId = 1;
        List<Cart> list = _cartDAO.findByUserId(userId);
        long provisionalPrice = getProvisionalPrice(list);
        req.setAttribute("carts", list);
        req.setAttribute("provisionalPrice", provisionalPrice);
        req.setAttribute("total", provisionalPrice);

        RequestDispatcher rd = req.getRequestDispatcher("/views/cart.jsp");
        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Object user = session.getAttribute("usercurrent");
        int userId = 1;
        String fullname = req.getParameter("fullname");
        String phoneNumber = req.getParameter("phone");
        String address = req.getParameter("address");
        String requirement = req.getParameter("requirement");

        Bill bill = new Bill();
        bill.setUser_Id(userId);
        bill.setFull_Name(fullname);
        bill.setPhone_number(phoneNumber);
        bill.setAddress(address);
        bill.setRequirement(requirement);
        List<Cart> carts = _cartDAO.findByUserId(userId);

        int billId = _billDAO.createBill(bill);
        List<BillDetail> details = createBillDetails(billId, carts);
        BigInteger total = totalOfBill(details);
        _billDAO.updateTotal(billId, total);
    }

    private long getProvisionalPrice(List<Cart> carts) {
        long result = 0;
        for (Cart cart : carts) {
            result += cart.getCartProduct().getPrice() * cart.getQuantity();
        }
        return result;
    }

    private List<BillDetail> createBillDetails(int billId, List<Cart> carts) {
        List<BillDetail> list = new ArrayList<>();
        for (Cart cart : carts) {
            BigInteger total = BigInteger.valueOf(cart.getQuantity() * cart.getCartProduct().getPrice());
            BillDetail detail = _billDetailDAO.create(billId, cart, total);
            list.add(detail);
        }
        return list;
    }

    private BigInteger totalOfBill(List<BillDetail> details) {
        BigInteger total = BigInteger.valueOf(0);
        for (BillDetail detail : details) {
            total.add(BigInteger.valueOf(detail.getTotal()));
        }
        return total;
    }
}
