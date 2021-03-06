package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ViewNotesRequest;
import by.tc.nb.bean.ViewNotesResponse;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.NBUtilities;

public class ViewNotes implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        if (request instanceof ViewNotesRequest) {

            ViewNotesResponse response = new ViewNotesResponse();
            response.setNotes(NoteBookProvider.getInstance().getNoteBook().getNotes());
            response.setErrorStatus(false);
            response.setResultMessage("Viewing all notes:");
            System.out.println(response.getResultMessage());
            return response;

        } else {
            throw new CommandException("Incorrect request");
        }
    }

}
