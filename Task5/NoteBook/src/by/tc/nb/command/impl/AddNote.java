package by.tc.nb.command.impl;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class AddNote implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        AddNoteRequest req;

        if (request instanceof AddNoteRequest) {

            req = (AddNoteRequest) request;
            Response response = new Response();
            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();

            String data = req.getData();
            String creationDate = req.getCreationDate();

            try {
                nbService.addNote(data,creationDate);
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Note has been successfully added");
            return response;
        }
        else {
            throw new CommandException("Incorrect request");
        }
    }

}
