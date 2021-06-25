package sellFan.dao.impl;

import sellFan.dao.iterface.ICartDAO;
import sellFan.dto.Cart;
import sellFan.mapper.CartMappper;
import sellFan.mapper.CartProductMapper;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class CartDAO extends AbstractDAO<Cart> implements ICartDAO {

    @Override
    public List<Cart> findByUserId(int userId) {
        String sql = "SELECT * FROM CART as c JOIN PRODUCT as p"
                + " WHERE c.PRODUCTID = p.ID AND USER_ID = ?";
        List<Cart> list = query(sql, new CartProductMapper(), userId);
        return list;
    }

    @Override
    public Cart findByCartId(int cartId) {
        String sql = "SELECT * FROM CART WHERE ID = ?";
        List<Cart> list = query(sql, new CartMappper(), cartId);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void updateQuantity(int cartId, int quantity) {
        String sql = "UPDATE CART SET QUANTITY = ? WHERE ID = ?";
        Update(sql, quantity, cartId);
    }

    @Override
    public void deleteById(int cartId) {
        String sql = "DELETE FROM CART WHERE ID = ?";
        Update(sql, cartId);
    }

    @Override
    public void addCart(int productId, int userId) {
        String sql = "INSERT INTO CART (user_id, productid, quantity) values (?, ?, ?)";
        Update(sql, userId, productId, 1);
    }

    @Override
    public Cart findByProductId(int productId) {
        String sql = "SELECT * FROM CART WHERE productid = ?";
        List<Cart> list = query(sql, new CartMappper(), productId);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void clearCart(int userId) {
        String sql = "DELETE FROM CART WHERE USER_ID = ?";
        Update(sql, userId);
    }

    @Override
    public int count(int userId) {
        String sql = "SELECT COUNT(*) FROM CART WHERE USER_ID = ?";
        int n = count(sql, userId);
        return n;
    }
}
