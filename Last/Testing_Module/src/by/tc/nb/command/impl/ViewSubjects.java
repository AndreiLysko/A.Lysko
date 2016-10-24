package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ViewNotesRequest;
import by.tc.nb.bean.ViewNotesResponse;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class ViewSubjects implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        ViewNotesRequest req;

        if (request instanceof ViewNotesRequest) {

            req = (ViewNotesRequest) request;
            ViewNotesResponse response = new ViewNotesResponse();
            TestModuleService nbService = ServiceFactory.getInstance().getTestModuleService();

            try {
                response.setQuestions(nbService.viewNotes(req.getUserID()));
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Viewing all notes:");
            return response;

        } else {
            throw new CommandException("Incorrect request");
        }
    }

}
