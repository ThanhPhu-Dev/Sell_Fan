package sellFan.dao.iterface;

import sellFan.mapper.RowMappper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMappper<T> rowMapper, Object... Parameters);
    void Update(String sql, Object... parameters);
    Long Insert(String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
