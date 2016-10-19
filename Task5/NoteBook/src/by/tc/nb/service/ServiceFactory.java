package by.tc.nb.service;

import by.tc.nb.service.impl.NotebookServiceImpl;
import by.tc.nb.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private NotebookService nbService = new NotebookServiceImpl();

    private UserService userService = new UserServiceImpl();

    public static ServiceFactory getInstance(){
        return instance;
    }

    public NotebookService getNoteBookService(){
        return nbService;
    }

    public UserService getUserService() {
        return userService;
    }
}
