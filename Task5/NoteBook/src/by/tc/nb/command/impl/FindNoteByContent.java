package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class FindNoteByContent implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        FindNoteByContentRequest req;

        if(request instanceof FindNoteByContentRequest) {

            req = (FindNoteByContentRequest) request;
            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();
            FindNoteByContentResponse response = new FindNoteByContentResponse();

            try {
                response.setNotes(nbService.findNoteByContent(req.getUserID(),req.getContent()));
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Search text found");
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
