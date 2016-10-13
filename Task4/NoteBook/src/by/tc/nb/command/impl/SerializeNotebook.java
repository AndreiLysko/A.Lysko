package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.SerializeNotebookRequest;
import by.tc.nb.bean.WriteNotebookToFileRequest;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class SerializeNotebook implements Command {

    @Override
    public Response execute(Request request) throws CommandException, ServiceException {

        if (request instanceof SerializeNotebookRequest) {

            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();
            Response response = new Response();

            try {
                nbService.serializeNotebook(((SerializeNotebookRequest) request).getFilePath());
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Notes have been successfully written to file ");
            System.out.println(response.getResultMessage() + ((WriteNotebookToFileRequest)request).getFilePath());
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
