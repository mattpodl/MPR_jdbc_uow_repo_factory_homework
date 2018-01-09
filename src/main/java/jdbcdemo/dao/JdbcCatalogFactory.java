package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jdbcdemo.dao.uow.JdbcUnitOfWork;
import jdbcdemo.dao.uow.UnitOfWork;

public class JdbcCatalogFactory implements DbCatalogFactory {

	public RepositoryCatalog HsqlDbWorkBd() {
		String url = "jdbc:hsqldb:hsql://localhost/workdb";
		String user = "SA";
		String password = "";
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, user, password);
			UnitOfWork uow = new JdbcUnitOfWork(connection);
			return new JdbcRepositoryCatalog(connection, uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
