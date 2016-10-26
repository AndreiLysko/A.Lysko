package by.tc.tm.service;

import by.tc.tm.bean.entity.User;
import by.tc.tm.service.exception.ServiceException;

public interface UserService {

    User authorization(String username, String password) throws ServiceException;

    boolean registration(String username, String password) throws ServiceException;
}
