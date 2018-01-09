package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbcdemo.dao.mappers.AccidentResultMapper;
import jdbcdemo.dao.mappers.CarResultMapper;
import jdbcdemo.dao.mappers.OwnerResultMapper;
import jdbcdemo.dao.uow.UnitOfWork;
import jdbcdemo.domain.Accident;
import jdbcdemo.domain.Car;
import jdbcdemo.domain.Owner;

public class JdbcRepositoryCatalog implements RepositoryCatalog {

	Connection connection;
	UnitOfWork uow;

	public JdbcRepositoryCatalog(Connection connection, UnitOfWork uow) {
		this.connection = connection;
		this.uow = uow;
	}

	public Repository<Owner> owners() {
		try {
			return new OwnerRepository(connection, new OwnerResultMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveChanges() {
		uow.saveChanges();
	}

	public Repository<Accident> accidents() {
		try {
			return new AccidentRepository(connection, new AccidentResultMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Repository<Car> cars() {
		try {
			return new CarRepository(connection, new CarResultMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
