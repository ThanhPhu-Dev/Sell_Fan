package sellFan.mapper;

import sellFan.dto.*;

import java.sql.ResultSet;
import java.util.List;
import javax.inject.Inject;
import sellFan.dao.iterface.*;

public class ProductDetailMapper implements RowMappper<ProductDetail> {

    private static final long serialVersionUID = -5866282446898633441L;
    @Inject
    IproductImageDAO _productImageDAO;

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
            List<ProductImage> t = _productImageDAO.getAllByProductId(rs.getInt("productid"));
//            p.setProductImages();
            return p;
        } catch (Exception e) {
            return null;
        }
    }
}
