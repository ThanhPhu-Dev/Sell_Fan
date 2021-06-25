package sellFan.dao.iterface;

import java.util.List;
import sellFan.dto.ProductType;

public interface IProductTypeDAO extends GenericDAO<ProductType>{
    public List<ProductType> getAllCat();
}
