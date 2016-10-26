package by.tc.tm.dao;

import by.tc.tm.dao.impl.mysql.MySQLUserDAO;

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
