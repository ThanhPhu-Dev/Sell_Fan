package sellFan.mapper;

import java.sql.ResultSet;

public interface RowMappper<T> {
    T mapRow(ResultSet rs);
}
