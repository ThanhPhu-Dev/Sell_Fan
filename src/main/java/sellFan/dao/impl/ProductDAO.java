package sellFan.dao.impl;

import java.util.List;
import sellFan.dao.iterface.IProductDAO;
import sellFan.dto.Product;

import javax.annotation.ManagedBean;
import sellFan.dto.Product;
import sellFan.dto.ProductDetail;
import sellFan.mapper.ProductDetailMapper;
import sellFan.mapper.ProductMapper;
import sellFan.mapper.UserMapper;

@ManagedBean
public class ProductDAO extends AbstractDAO<Product> implements IProductDAO {

    @Override
    public List<Product> getAllProductByCatAndName(String cat, String name) {
        String query = "SELECT * FROM Product where typeid=? and name like ?";
        List<Product> products = query(query, new ProductMapper(), cat, "%" + name + "%");
        return products;
    }

    @Override
    public List<Product> getAllProduct() {
        String query = "SELECT * FROM Product";
        List<Product> products = query(query, new ProductMapper());
        return products;
    }

    @Override
    public List<Product> getAllProductByCat(String cat) {
        String query = "SELECT * FROM Product where typeid=?";
        List<Product> products = query(query, new ProductMapper(), cat);
        return products;
    }

    @Override
    public List<Product> getAllProductByName(String name) {
        String query = "SELECT * FROM Product where name like ?";
        List<Product> products = query(query, new ProductMapper(), "%" + name + "%");
        return products;
    }

    @Override
    public Product getProductById(int id) {
        String query = "SELECT * FROM product where id=?";
        List<Product> products = query(query, new ProductMapper(), id);
        return products.get(0);
    }

    @Override
    public void updateStock(int id, int stock) {
        String sql = "UPDATE PRODUCT SET STOCK = ? WHERE ID = ?";
        Update(sql, stock, id);
    }
}
