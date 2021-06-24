package sellFan.dao.iterface;

import sellFan.dto.User;

public interface IUserDAO extends GenericDAO<User>{
    public User findByEmail(String email);
    public User save(User user);
}
