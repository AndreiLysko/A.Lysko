package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ViewNotesRequest;
import by.tc.nb.bean.ViewNotesResponse;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;

public class ViewNotes implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        if (request instanceof ViewNotesRequest) {

            ViewNotesResponse response = new ViewNotesResponse();
            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();

            try {
                nbService.viewNotes();
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setNotes(NoteBookProvider.getInstance().getNoteBook().getNotes());
            response.setErrorStatus(false);
            response.setResultMessage("Viewing all notes:");
            return response;

        } else {
            throw new CommandException("Incorrect request");
        }
    }

}
