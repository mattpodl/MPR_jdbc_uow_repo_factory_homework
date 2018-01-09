package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetMapper<TEntity> {

	public TEntity map(ResultSet rs) throws SQLException;
}
