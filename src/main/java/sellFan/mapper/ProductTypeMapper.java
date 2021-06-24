package sellFan.mapper;

import sellFan.dto.*;

import java.sql.ResultSet;

public class ProductTypeMapper implements RowMappper<ProductType>{
    @Override
    public ProductType mapRow(ResultSet rs) {
        try {
            ProductType p = new ProductType();
            p.setId(rs.getInt("Id"));
            p.setName(rs.getString("Name"));
            return p;
        } catch (Exception e) {
        return null;
        }
    }
}
