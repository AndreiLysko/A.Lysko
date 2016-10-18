package by.tc.nb.dao.impl.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import by.tc.nb.dao.UserDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.impl.pool.ConnectionPool;

public class MySQLUserDAO implements UserDAO {

	@Override
	public boolean authorization(String login, String password) throws DAOException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectionPool.getInstance().getConnection();
			st = con.createStatement();

		} catch (SQLException e) {
			throw new DAOException();
		} catch (InterruptedException e) {
			throw new DAOException();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (SQLException e) {
			} catch (InterruptedException e) {
			}
		}

		return true;

	}

}
