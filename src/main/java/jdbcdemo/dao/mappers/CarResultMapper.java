package jdbcdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcdemo.domain.Car;

public class CarResultMapper implements ResultSetMapper<Car> {

	public Car map(ResultSet rs) throws SQLException {
		return new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("registration"), rs.getInt("owners_id"));
	}

}
