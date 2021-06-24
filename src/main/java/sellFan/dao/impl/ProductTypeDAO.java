package sellFan.dao.impl;

import java.util.List;
import sellFan.dao.iterface.IProductTypeDAO;
import sellFan.dto.ProductType;

import javax.annotation.ManagedBean;
import sellFan.mapper.*;

@ManagedBean
public class ProductTypeDAO extends AbstractDAO<ProductType> implements IProductTypeDAO {

    @Override
    public List<ProductType> getAllCat() {
         String query = "SELECT * FROM product_type";
        List<ProductType> categogies =  query(query, new ProductTypeMapper());
        return categogies;
    }

}
