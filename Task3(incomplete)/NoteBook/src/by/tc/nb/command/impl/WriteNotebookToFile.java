package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.WriteNotebookToFileRequest;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.NBUtilities;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WriteNotebookToFile implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        if (request instanceof WriteNotebookToFileRequest){
            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
            try {
                NBUtilities.writeNotesToFile(((WriteNotebookToFileRequest)request).getFilePath(),noteBook);
            } catch (FileNotFoundException e) {
                throw new CommandException("Incorrect filepath");
            }
            catch (IOException e){
                throw new CommandException("IOException");
            }

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("Notes have been successfully written to file");
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
