package sellFan.mapper;

import sellFan.dto.ProductImage;

import java.sql.ResultSet;

public class ProductImageMapper implements RowMappper<ProductImage>{
    @Override
    public ProductImage mapRow(ResultSet rs) {
        try {
            ProductImage p = new ProductImage();
            p.setProductId(rs.getInt("productid"));
            p.setImage(rs.getString("image"));
            
            return p;
        } catch (Exception e) {
        return null;
        }
    }
}
