package sellFan.dao.impl;

import java.util.List;
import sellFan.dao.iterface.IproductImageDAO;
import sellFan.dto.ProductImage;

import javax.annotation.ManagedBean;
import sellFan.dto.ProductImage;
import sellFan.mapper.ProductImageMapper;

@ManagedBean
public class ProductImageDAO extends AbstractDAO<ProductImage> implements IproductImageDAO {

    @Override
    public List<ProductImage> getAllByProductId(int id) {
        String query = "SELECT * FROM product_images";
        List<ProductImage> products = query(query, new ProductImageMapper());
        return products;
    }
}
