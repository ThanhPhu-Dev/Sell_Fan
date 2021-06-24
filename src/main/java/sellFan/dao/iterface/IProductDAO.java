package sellFan.dao.iterface;

import java.util.List;
import sellFan.dto.Product;

public interface IProductDAO extends GenericDAO<Product>{
    public Product getProductById(int id);
    public List<Product> getAllProduct();
    public List<Product> getAllProductByCat(String cat);
    public List<Product> getAllProductByName(String name);
    public List<Product> getAllProductByCatAndName(String cat, String name);
}
