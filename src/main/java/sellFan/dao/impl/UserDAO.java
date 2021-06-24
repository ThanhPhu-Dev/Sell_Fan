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
    public User findById(Integer id) {
        String query = "SELECT * FROM user where id=?";
        List<User> user =  query(query, new UserMapper(), id);
        return user.isEmpty() ? null: user.get(0);
    }

    @Override
    public User save(User user) {
        String query = "INSERT INTO user(email, hashedPw, fullname, code) values (?,?,?,?)";
        Long id = Insert(query,user.getEmail(),user.getHashedPw(),user.getFullName(), user.getCode());
        return findById(id.intValue());
    }

    @Override
    public void update(User user) {
        String query = "UPDATE user SET email = ? , hashedPw = ? , fullname = ? , code = ? , status = 1 where id = ?";
        Update(query,user.getEmail(),user.getHashedPw(),user.getFullName(), user.getCode(), user.getId());
    }
}
