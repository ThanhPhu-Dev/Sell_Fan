package sellFan.dao.impl;


import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.User;
import sellFan.mapper.UserMapper;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM user where email=?";
        List<User> user =  query(query, new UserMapper(), email);
        return user.isEmpty() ? null: user.get(0);
    }

    @Override
    public User save(User user) {
        String query = "INSERT INTO user(email, hashedPw, fullname) values (?,?,?)";
        Insert(query,user.getEmail(),user.getHashedPw(),user.getFullName());
        return user;
    }
}
