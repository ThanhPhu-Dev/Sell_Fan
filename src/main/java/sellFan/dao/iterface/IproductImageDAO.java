package sellFan.dao.iterface;

import java.util.List;
import sellFan.dto.ProductImage;

public interface IproductImageDAO extends GenericDAO<ProductImage>{
    public List<ProductImage> getAllByProductId(int id);
}
