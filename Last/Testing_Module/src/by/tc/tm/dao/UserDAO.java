package by.tc.tm.dao;

import by.tc.tm.bean.entity.User;
import by.tc.tm.dao.exception.DAOException;

public interface UserDAO {

	User authorization(String username, String password) throws DAOException;
    boolean registration(String username, String password) throws DAOException;

}
