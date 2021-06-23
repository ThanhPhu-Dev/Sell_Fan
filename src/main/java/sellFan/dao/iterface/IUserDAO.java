package sellFan.dao.iterface;

import sellFan.dto.User;

public interface IUserDAO extends GenericDAO<User>{
    User findByEmail(String email);
}
