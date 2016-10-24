package by.tc.nb.dao;

import by.tc.nb.dao.impl.mysql.MySQLUserDAO;

public class UserDAOFactory {

    private static final UserDAOFactory instance = new UserDAOFactory();
    private UserDAO userDAO = new MySQLUserDAO();

    public static UserDAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
