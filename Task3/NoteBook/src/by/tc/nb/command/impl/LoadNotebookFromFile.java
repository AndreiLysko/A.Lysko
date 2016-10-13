package by.tc.nb.command.impl;

import by.tc.nb.bean.LoadNotebookFromFileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.NBUtilities;

import java.io.IOException;

public class LoadNotebookFromFile implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        if (request instanceof LoadNotebookFromFileRequest) {
            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
            try {
                NBUtilities.loadNotesFromFile(((LoadNotebookFromFileRequest) request).getFilePath(), noteBook);
            } catch (IOException e) {
                throw new CommandException("Incorrect filepath");
            }

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("Notes have been successfully read");
            System.out.println(response.getResultMessage());

            return response;

        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
