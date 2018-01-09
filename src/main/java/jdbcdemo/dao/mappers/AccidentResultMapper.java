package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcdemo.domain.Accident;

public class AccidentResultMapper implements ResultSetMapper<Accident> {

	public Accident map(ResultSet rs) throws SQLException {
		return new Accident(rs.getInt("id"), rs.getInt("car_id"), rs.getDate("date"), rs.getString("description"));
	}

}
