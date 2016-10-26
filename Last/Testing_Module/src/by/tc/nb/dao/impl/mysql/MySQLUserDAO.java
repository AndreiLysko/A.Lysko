package by.tc.nb.dao.impl.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.tc.nb.bean.entity.User;
import by.tc.nb.dao.UserDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.impl.pool.ConnectionPool;

public class MySQLUserDAO implements UserDAO {

	@Override
	public User authorization(String username, String password) throws DAOException {

		User user = null;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT id, login, privileges FROM USERS WHERE login='"
					+ username + "' AND password='" + password + "';");
			if (result.next()){
				user = new User(result.getInt(1),result.getString(2),result.getInt(3));
			}

		} catch (InterruptedException | SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
					ConnectionPool.getInstance().returnConnection(connection);
				} catch (InterruptedException | SQLException e) {
					throw new DAOException(e.getMessage());
				}
			}
		}

		return user;

	}

	@Override
	public boolean registration(String username, String password) throws DAOException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			int result = statement.executeUpdate("INSERT INTO USERS(login,password) VALUES('"
					+ username +"', '" + password +"');");
			return (result != 0);

		} catch (InterruptedException | SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				statement.close();
				ConnectionPool.getInstance().returnConnection(connection);
			} catch (SQLException | InterruptedException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

}
