package sellFan.dao.impl;

import sellFan.dao.iterface.IBillDAO;
import sellFan.dto.Bill;
import sellFan.mapper.BillMappper;

import javax.annotation.ManagedBean;
import java.math.BigInteger;
import java.util.List;

@ManagedBean
public class BillDAO extends AbstractDAO<Bill> implements IBillDAO {
    @Override
    public int createBill(Bill bill) {
        String sql = "INSERT INTO BILL(USER_ID, FULL_NAME, GENDER, PHONE_NUMBER, ADDRESS, TOTAL) VALUES(?, ?, ?, ?, ?, ?)";
        Long id = Insert(sql, bill.getUser_Id(), bill.getFull_Name(), bill.getGender(),
                bill.getPhone_number(), bill.getAddress(), 0);
        return id.intValue();
    }

    @Override
    public void updateTotal(int billId, int total) {
        String sql = "UPDATE BILL SET TOTAL = ? WHERE ID = ?";
        Update(sql, total, billId);
    }

    @Override
    public List<Bill> findBillsByUserId(int userId) {
        String sql = "SELECT * FROM BILL WHERE USER_ID = ? ORDER BY DATE_CREATED DESC";
        List<Bill> list = query(sql, new BillMappper(), userId);
        return list;
    }
}
