package sellFan.mapper;

import sellFan.dto.User;

import java.sql.ResultSet;
import sellFan.dto.Product;

public class ProductMapper implements RowMappper<Product> {

    @Override
    public Product mapRow(ResultSet rs) {
        try {
            Product p = new Product();
            p.setId(rs.getInt("Id"));
            p.setTypeId(rs.getInt("TypeId"));
            p.setName(rs.getString("Name"));
            p.setPrice(rs.getInt("Price"));
            p.setStock(rs.getInt("Stock"));
            p.setImage(rs.getString("Image"));
            return p;

        } catch (Exception e) {
            return null;
        }
    }
}
