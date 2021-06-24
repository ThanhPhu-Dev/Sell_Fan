package sellFan.dao.iterface;

import java.util.List;
import sellFan.dto.Product;

public interface IProductDAO extends GenericDAO<Product>{
    public List<Product> getAllProduct();
    public List<Product> getAllProductByCat(String cat);
    public List<Product> getAllProductByCatAndName(String cat, String name);
}
