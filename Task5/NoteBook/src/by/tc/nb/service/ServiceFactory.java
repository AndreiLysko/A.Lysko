package by.tc.nb.service;

import by.tc.nb.service.impl.NotebookServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private NotebookService nbService = new NotebookServiceImpl();

    public static ServiceFactory getInstance(){
        return instance;
    }

    public NotebookService getNoteBookService(){
        return nbService;
    }
}
