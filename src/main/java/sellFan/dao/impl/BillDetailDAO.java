package sellFan.dao.impl;

import sellFan.dao.iterface.IBillDetailDAO;
import sellFan.dto.BillDetail;
import sellFan.dto.Cart;
import sellFan.mapper.BillDetailMappper;
import sellFan.mapper.BillDetailProductMapper;

import javax.annotation.ManagedBean;
import java.math.BigInteger;
import java.util.List;

@ManagedBean
public class BillDetailDAO extends AbstractDAO<BillDetail> implements IBillDetailDAO {

    @Override
    public BillDetail findById(int id) {
        String sql = "SELECT * FROM BILL_DETAIL WHERE ID = ?";
        List<BillDetail> list = query(sql, new BillDetailMappper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public BillDetail create(int billId, Cart cart, int total) {
        String sql = "INSERT INTO BILL_DETAIL(BILLID, PRODUCTID, QUANTITY, TOTAL) VALUES(?, ?, ?, ?)";
        Long id = Insert(sql, billId, cart.getProductId(), cart.getQuantity(), total);
        return findById(id.intValue());
    }

    @Override
    public List<BillDetail> findByBillId(int billId) {
        String sql = "SELECT * FROM BILL_DETAIL as bd JOIN PRODUCT as p WHERE bd.PRODUCTID = p.ID " +
                "AND BILLID = ?";
        List<BillDetail> list = query(sql, new BillDetailProductMapper(), billId);
        return list;
    }
}
