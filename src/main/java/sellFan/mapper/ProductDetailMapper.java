package sellFan.mapper;

import sellFan.dto.ProductDetail;

import java.sql.ResultSet;

public class ProductDetailMapper implements RowMappper<ProductDetail> {

    @Override
    public ProductDetail mapRow(ResultSet rs) {
        try {
            ProductDetail p = new ProductDetail();
            p.setProductId(rs.getInt("productid"));
            p.setType(rs.getString("type"));
            p.setDiameter(rs.getString("diameter"));
            p.setWindMode(rs.getString("wind_mode"));
            p.setDashBoard(rs.getString("dashboard"));
            p.setMotorType(rs.getString("motor_type"));
            p.setUtility(rs.getString("utility"));
            p.setSizeWight(rs.getString("size_weight"));
            p.setBrandName(rs.getString("brand_name"));
            p.setMadeIn(rs.getString("made_in"));
            p.setDebutYear(rs.getString("debut_year"));
            p.setCompany(rs.getString("company"));
            p.setImage(rs.getString("image"));
            
            return p;
        } catch (Exception e) {
            return null;
        }
    }
}
