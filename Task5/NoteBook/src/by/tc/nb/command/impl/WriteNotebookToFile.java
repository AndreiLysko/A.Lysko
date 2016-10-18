package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.WriteNotebookToFileRequest;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;

public class WriteNotebookToFile implements Command {

    @Override
    public Response execute(Request request) throws CommandException, IOException {

        WriteNotebookToFileRequest req;

        if (request instanceof WriteNotebookToFileRequest) {

            req = (WriteNotebookToFileRequest) request;
            String filePath = req.getFilePath();
            Response response = new Response();
            NotebookService nbService = ServiceFactory.getInstance().getNoteBookService();

            try {
                nbService.writeNotebookToFile(filePath);
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Notes have been successfully written to file ");
            return response;

        }
        else {
            throw new CommandException("Incorrect request");
        }
    }
}
