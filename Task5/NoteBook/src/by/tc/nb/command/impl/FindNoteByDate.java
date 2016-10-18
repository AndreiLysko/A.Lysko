package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class FindNoteByDate implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        FindNoteByDateRequest req;

        if(request instanceof FindNoteByDateRequest) {

            req = (FindNoteByDateRequest) request;
            String searchDate = req.getDate();
            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();
            FindNoteByDateResponse response = new FindNoteByDateResponse();

            try {
                response.setNotes(nbService.findNoteByDate(searchDate));
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Search date found");
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
