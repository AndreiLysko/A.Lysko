package by.tc.nb.dao;

import by.tc.nb.bean.entity.User;
import by.tc.nb.dao.exception.DAOException;

public interface UserDAO {

	User authorization(String username, String password) throws DAOException;
    boolean registration(String username, String password) throws DAOException;

}
