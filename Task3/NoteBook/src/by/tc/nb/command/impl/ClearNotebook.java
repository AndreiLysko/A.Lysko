package by.tc.nb.command.impl;

import by.tc.nb.bean.ClearNotebookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class ClearNotebook implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        if (request instanceof ClearNotebookRequest){
            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
            noteBook.getNotes().clear();

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("Notebook has been successfully cleared!");
            System.out.println(response.getResultMessage());

            return response;
        }
        else {
            throw new CommandException("Incorrect request");
        }
    }

}
