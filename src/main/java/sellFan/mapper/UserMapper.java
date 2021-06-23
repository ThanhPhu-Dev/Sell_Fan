package sellFan.mapper;

import sellFan.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMappper<User> {
    @Override
    public User mapRow(ResultSet rs) {
        try {
            return User.builder()
                    .Email(rs.getString("email"))
                    .FullName(rs.getString("fullname"))
                    .HashedPw(rs.getString("hashedPw"))
                    .build();
        } catch (SQLException throwables) {
            return null;
        }

    }
}
