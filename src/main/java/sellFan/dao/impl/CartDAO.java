package sellFan.dao.impl;


import sellFan.dao.iterface.ICartDAO;
import sellFan.dto.Cart;
import sellFan.mapper.CartMappper;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class CartDAO  extends AbstractDAO<Cart> implements ICartDAO {
    @Override
    public List<Cart> findByUserId(int userId) {
        String sql = "SELECT * FROM CART as c JOIN PRODUCT as p" +
                " WHERE c.PRODUCTID = p.ID AND USER_ID = ?";
        List<Cart> list = query(sql, new CartMappper(), userId);
        return list;
    }
}
