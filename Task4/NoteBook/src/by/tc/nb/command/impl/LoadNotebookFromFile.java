package by.tc.nb.command.impl;

import by.tc.nb.bean.LoadNotebookFromFileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.NBUtilities;

import java.io.IOException;

public class LoadNotebookFromFile implements Command {

    @Override
    public Response execute(Request request) throws CommandException, IOException {

        LoadNotebookFromFileRequest req;

        if (request instanceof LoadNotebookFromFileRequest) {

            req = (LoadNotebookFromFileRequest) request;
            String filePath = req.getFilePath();
            Response response = new Response();
            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();

            try {
                nbService.loadNotebookFromFile(filePath);
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Notes have been successfully read");
            System.out.println(response.getResultMessage());
            return response;

        }
        else {
            throw new CommandException("Incorrect request");
        }
    }
}
