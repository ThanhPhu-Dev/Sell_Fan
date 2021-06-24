package sellFan.dao.iterface;

import sellFan.dto.Cart;

import java.util.List;

public interface ICartDAO extends GenericDAO<Cart>{
    public List<Cart> findByUserId(int userId);
}
