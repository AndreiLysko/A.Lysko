package by.tc.nb.command.impl;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.NBUtilities;

public class AddNote implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        AddNoteRequest req;

        if (request instanceof AddNoteRequest) {
            req = (AddNoteRequest) request;
        } else {
            throw new CommandException("Incorrect request");
        }

        String data = req.getData();
        String creationDate = req.getCreationDate();
        Note note = new Note(data, creationDate);

        NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
        NBUtilities.addNote(notebook, note);

        Response response = new Response();
        response.setErrorStatus(false);
        response.setResultMessage("Note has been successfully added --> ");
        System.out.println(response.getResultMessage() + note.toString());

        return response;
    }

}
