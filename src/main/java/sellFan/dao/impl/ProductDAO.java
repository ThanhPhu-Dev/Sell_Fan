package sellFan.dao.impl;

import sellFan.dao.iterface.IProductDAO;
import sellFan.dto.Product;

import javax.annotation.ManagedBean;

@ManagedBean
public class ProductDAO  extends AbstractDAO<Product> implements IProductDAO {
}
