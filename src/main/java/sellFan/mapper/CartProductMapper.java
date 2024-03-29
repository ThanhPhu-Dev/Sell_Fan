package sellFan.mapper;

import sellFan.dto.Cart;
import sellFan.dto.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartProductMapper implements RowMappper<Cart>{
    @Override
    public Cart mapRow(ResultSet rs) {
        try {
            Cart cart = new Cart();
            cart.setId(rs.getInt("id"));
            cart.setUser_Id(rs.getInt("user_id"));
            cart.setProductId(rs.getInt("productid"));
            cart.setQuantity(rs.getInt("quantity"));

            Product product = new Product();
            product.setId(rs.getInt("productid"));
            product.setTypeId(rs.getInt("typeid"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getInt("price"));
            product.setStock(rs.getInt("stock"));
            product.setImage(rs.getString("image"));

            cart.setCartProduct(product);
            return cart;
        } catch (SQLException ex) {
            return null;
        }
    }
}
