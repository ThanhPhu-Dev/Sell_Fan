package sellFan.dao.impl;

import sellFan.dao.iterface.IBillDAO;
import sellFan.dto.Bill;
import sellFan.mapper.BillMappper;

import javax.annotation.ManagedBean;
import java.math.BigInteger;

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
    public void updateTotal(int billId, BigInteger total) {
        String sql = "UPDATE BILL SET TOTAL = ? WHERE ID = ?";
        Update(sql, total, billId);
    }
}
