package sellFan.dao.impl;

import java.util.List;
import sellFan.dao.iterface.IProductDAO;
import sellFan.dto.Product;

import javax.annotation.ManagedBean;
import sellFan.dto.Product;
import sellFan.mapper.ProductMapper;
import sellFan.mapper.UserMapper;

@ManagedBean
public class ProductDAO  extends AbstractDAO<Product> implements IProductDAO {

    @Override
    public List<Product> getAllProduct() {
        String query = "SELECT * FROM Product";
        List<Product> products =  query(query, new ProductMapper());
        return products;
    }

    @Override
    public List<Product> getAllProductByCat(String cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAllProductByCatAndName(String cat, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
