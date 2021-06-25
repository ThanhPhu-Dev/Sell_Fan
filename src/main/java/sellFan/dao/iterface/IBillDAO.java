package sellFan.dao.iterface;

import sellFan.dto.Bill;

import java.math.BigInteger;

public interface IBillDAO extends GenericDAO<Bill>{
    public int createBill(Bill bill);
    public void updateTotal(int billId, int total);
}
