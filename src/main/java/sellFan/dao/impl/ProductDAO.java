package sellFan.dao.impl;

import java.util.List;
import sellFan.dao.iterface.IProductDAO;
import sellFan.dto.Product;

import javax.annotation.ManagedBean;

@ManagedBean
public class ProductDAO  extends AbstractDAO<Product> implements IProductDAO {

    @Override
    public List<Product> getAllProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
