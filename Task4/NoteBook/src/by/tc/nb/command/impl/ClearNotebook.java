package by.tc.nb.command.impl;

import by.tc.nb.bean.ClearNotebookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class ClearNotebook implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        if (request instanceof ClearNotebookRequest){

            Response response = new Response();
            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();

            try {
                nbService.clearNotebook();
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Notebook has been successfully cleared!");

            return response;
        }
        else {
            throw new CommandException("Incorrect request");
        }
    }

}
