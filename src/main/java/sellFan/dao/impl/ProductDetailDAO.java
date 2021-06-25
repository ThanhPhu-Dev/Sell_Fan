package sellFan.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import sellFan.dao.iterface.IProductDetailDAO;
import sellFan.dto.ProductDetail;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import sellFan.dao.iterface.IproductImageDAO;
import sellFan.dto.Product;
import sellFan.dto.ProductImage;
import sellFan.mapper.ProductDetailMapper;

@ManagedBean
public class ProductDetailDAO extends AbstractDAO<ProductDetail> implements IProductDetailDAO {

    @Inject
    IproductImageDAO _productImageDAO;

    @Override
    public ProductDetail getProductDetailById(int id) {
        String query = "SELECT * FROM product_detail where productid=?";
        List<ProductDetail> products = query(query, new ProductDetailMapper(), id);
        return products.get(0);
    }
}
