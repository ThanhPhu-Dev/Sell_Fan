package sellFan.mapper;

import sellFan.dto.Bill;
import sellFan.dto.BillDetail;
import sellFan.dto.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDetailProductMapper implements RowMappper<BillDetail>{
    @Override
    public BillDetail mapRow(ResultSet rs) {
        try {
            BillDetail detail = new BillDetail();
            detail.setId(rs.getInt("id"));
            detail.setBillId(rs.getInt("billid"));
            detail.setProductId(rs.getInt("productid"));
            detail.setQuantity(rs.getInt("quantity"));
            detail.setTotal(rs.getInt("total"));
            detail.setDate_Created(rs.getDate("date_created"));

            Product product = new Product();
            product.setId(rs.getInt("productid"));
            product.setTypeId(rs.getInt("typeid"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getInt("price"));
            product.setStock(rs.getInt("stock"));
            product.setImage(rs.getString("image"));

            detail.setBillDetailProduct(product);
            return detail;
        } catch (SQLException ex) {
            return null;
        }
    }
}
