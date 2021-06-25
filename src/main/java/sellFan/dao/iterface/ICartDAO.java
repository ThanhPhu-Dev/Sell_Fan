package sellFan.dao.iterface;

import sellFan.dto.Cart;

import java.util.List;

public interface ICartDAO extends GenericDAO<Cart>{
    public List<Cart> findByUserId(int userId);
    public Cart findByCartId(int cartId);
    public void updateQuantity(int cartId, int quantity);
    public void deleteById(int cartId);
    public void addCart(int productId, int userId);
    public Cart findByProductId(int productId);
    public void clearCart(int userId);
    public int count(int userId);
}
