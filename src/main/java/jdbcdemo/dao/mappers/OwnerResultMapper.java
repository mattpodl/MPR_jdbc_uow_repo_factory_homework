package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcdemo.domain.Owner;

public class OwnerResultMapper implements ResultSetMapper<Owner> {

	public Owner map(ResultSet rs) throws SQLException {
		Owner o = new Owner();
		o.setId(rs.getInt("id"));
		o.setName(rs.getString("name"));
		o.setSurname(rs.getString("surname"));
		o.setAge(rs.getInt("age"));
		return o;
	}

}
