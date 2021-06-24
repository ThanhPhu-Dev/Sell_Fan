package sellFan.dao.impl;

import sellFan.dao.iterface.IBillDetailDAO;
import sellFan.dto.Bill;
import sellFan.dto.BillDetail;
import sellFan.dto.Cart;
import sellFan.mapper.BillDetailMappper;
import sellFan.mapper.BillMappper;

import javax.annotation.ManagedBean;
import java.math.BigInteger;
import java.util.List;

@ManagedBean
public class BillDetailDAO extends AbstractDAO<BillDetail> implements IBillDetailDAO {
    @Override
    public BillDetail findById(int id) {
        String sql = "SELECT * FROM DETAIL_BILL WHERE ID = ?";
        List<BillDetail> list = query(sql, new BillDetailMappper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public BillDetail create(int billId, Cart cart, BigInteger total) {
        String sql = "INSERT INTO DETAIL_BILL(BILLID, PRODUCTID, QUANTITY, TOTAL) VALUES(?, ?, ?, ?)";
        Long id = Insert(sql, new BillDetailMappper(), billId, cart.getProductId(), cart.getQuantity(), total);
        return findById(id.intValue());
    }
}
