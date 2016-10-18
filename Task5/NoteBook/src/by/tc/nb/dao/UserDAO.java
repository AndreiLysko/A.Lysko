package by.tc.nb.dao;

import by.tc.nb.dao.exception.DAOException;

public interface UserDAO {
	boolean logination(String login, String password) throws DAOException;
}
