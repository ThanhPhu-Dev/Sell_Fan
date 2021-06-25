package sellFan.dao.iterface;

import sellFan.dto.BillDetail;
import sellFan.dto.Cart;

import java.math.BigInteger;
import java.util.List;

public interface IBillDetailDAO extends GenericDAO<BillDetail>{
    public BillDetail findById(int id);
    public BillDetail create(int billId, Cart cart, BigInteger total);
    public List<BillDetail> findByBillId(int billId);
}
