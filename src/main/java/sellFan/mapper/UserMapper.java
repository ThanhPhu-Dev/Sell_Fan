package sellFan.mapper;

import sellFan.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMappper<User> {
    @Override
    public User mapRow(ResultSet rs) {
        try {
            User u = new User();
            u.setEmail(rs.getString("email"));
            u.setFullName(rs.getString("fullname"));
            u.setHashedPw(rs.getString("hashedPw"));
            return u;
        } catch (SQLException throwables) {
            return null;
        }

    }
}
