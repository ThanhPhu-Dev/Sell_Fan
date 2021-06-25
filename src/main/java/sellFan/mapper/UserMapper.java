package sellFan.mapper;

import sellFan.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMappper<User> {
    @Override
    public User mapRow(ResultSet rs) {
        try {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setEmail(rs.getString("email"));
            u.setFullName(rs.getString("fullname"));
            u.setHashedPw(rs.getString("hashedPw"));
            u.setCode(rs.getString("code"));
            u.setStatus(rs.getInt("status"));
            return u;
        } catch (SQLException throwables) {
            return null;
        }

    }
}
