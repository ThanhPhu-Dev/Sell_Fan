package sellFan.dao.iterface;

import sellFan.dto.ProductDetail;

public interface IProductDetailDAO extends GenericDAO<ProductDetail>{
    public ProductDetail getProductDetailById(int id);
}
