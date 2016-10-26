package by.tc.tm.service.impl;

import by.tc.tm.bean.entity.User;
import by.tc.tm.dao.UserDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.service.UserService;
import by.tc.tm.service.exception.ServiceException;
import by.tc.tm.utils.check.Validate;

public class UserServiceImpl implements UserService {

    @Override
    public User authorization(String username, String password) throws ServiceException {
        if(!Validate.loginParameters(username, password)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return UserDAOFactory.getInstance().getUserDAO().authorization(username, password);
        } catch (DAOException e) {
            throw new ServiceException("authorization failed " + e.getMessage());
        }
    }

    @Override
    public boolean registration(String username, String password) throws ServiceException {
        if(!Validate.loginParameters(username, password)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return UserDAOFactory.getInstance().getUserDAO().registration(username, password);
        } catch (DAOException e) {
            throw new ServiceException("registry failed " + e.getMessage());
        }
    }
}
