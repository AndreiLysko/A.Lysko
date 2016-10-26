package by.tc.tm.service;

import by.tc.tm.service.impl.TestModuleServiceImpl;
import by.tc.tm.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private TestModuleService testModuleService = new TestModuleServiceImpl();

    private UserService userService = new UserServiceImpl();

    public static ServiceFactory getInstance(){
        return instance;
    }

    public TestModuleService getTestModuleService(){
        return testModuleService;
    }

    public UserService getUserService() {
        return userService;
    }
}
