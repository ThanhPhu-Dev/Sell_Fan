package sellFan.controller;

import sellFan.dao.iterface.IBillDAO;
import sellFan.dao.iterface.IBillDetailDAO;
import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.Bill;
import sellFan.dto.BillDetail;
import sellFan.dto.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/purchase/history"})
public class PurchaseHistoryController extends HttpServlet {
    @Inject
    IUserDAO _userDAO;

    @Inject
    IBillDAO _billDAO;

    @Inject
    IBillDetailDAO _billDetailDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int userId = 1;
        User user = _userDAO.findById(userId);
        List<Bill> billList =  _billDAO.findBillsByUserId(userId);
        List<BillDetail> list = getDetails(billList);
        req.setAttribute("list", list);
        req.setAttribute("customerName", user.getFullName());
        RequestDispatcher rd = req.getRequestDispatcher("/views/purchaseHistory.jsp");
        rd.forward(req, res);
    }

    private List<BillDetail> getDetails(List<Bill> billList) {
        List<BillDetail> list = new ArrayList<>();
        for (Bill bill : billList) {
            List<BillDetail> details = _billDetailDAO.findByBillId(bill.getId());
            list.addAll(details);
        }
        return list;
    }
}
