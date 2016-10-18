package by.tc.nb.command.impl;

import by.tc.nb.bean.DeserializeNotebookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.WriteNotebookToFileRequest;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class DeserializeNotebook implements Command {

    @Override
    public Response execute(Request request) throws CommandException{

        if(request instanceof DeserializeNotebookRequest) {

            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();
            Response response = new Response();

            try {
                nbService.deserializeNotebook(((DeserializeNotebookRequest)request).getFilePath());
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Notes have been successfully deserialized from file " +
                    ((DeserializeNotebookRequest) request).getFilePath());
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }

}
