package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.User;
import by.tc.nb.dao.UserDAOFactory;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.UserService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.utils.check.Validate;

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
