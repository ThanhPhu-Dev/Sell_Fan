package sellFan.mapper;

import sellFan.dto.Cart;
import sellFan.dto.Product;
import sellFan.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMappper implements RowMappper<Cart>{
    @Override
    public Cart mapRow(ResultSet rs) {
        try {
            Cart cart = new Cart();
            cart.setId(rs.getInt("id"));
            cart.setUser_Id(rs.getInt("user_id"));
            cart.setProductId(rs.getInt("productid"));
            cart.setQuantity(rs.getInt("quantity"));
            return cart;
        } catch (SQLException ex) {
            return null;
        }
    }
}
