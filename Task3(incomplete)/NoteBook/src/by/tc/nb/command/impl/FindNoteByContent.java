package by.tc.nb.command.impl;

import by.tc.nb.bean.FindNoteByContentRequest;
import by.tc.nb.bean.FindNoteByContentResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.NBUtilities;

public class FindNoteByContent implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        FindNoteByContentRequest req;

        if (request instanceof FindNoteByContentRequest) {
            req = (FindNoteByContentRequest) request;
        } else {
            throw new CommandException("Incorrect request");
        }

        String searchContent = req.getContent();

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        NBUtilities.findNotesByContent(searchContent, noteBook);

        FindNoteByContentResponse response = new FindNoteByContentResponse();
        response.setNotes(NBUtilities.findNotesByContent(searchContent, noteBook));
        response.setErrorStatus(false);
        response.setResultMessage("Search text found");
        System.out.println(response.getResultMessage());

        return response;
    }
}
