package sellFan.mapper;

import sellFan.dto.BillDetail;
import sellFan.dto.Cart;
import sellFan.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDetailMappper implements RowMappper<BillDetail>{
    @Override
    public BillDetail mapRow(ResultSet rs) {
        try {
            BillDetail detail = new BillDetail();
            detail.setId(rs.getInt("id"));
            detail.setBillId(rs.getInt("billid"));
            detail.setProductId(rs.getInt("productid"));
            detail.setQuantity(rs.getInt("quantity"));
            detail.setTotal(rs.getInt("total"));

            return detail;
        } catch (SQLException ex) {
            return null;
        }
    }
}
