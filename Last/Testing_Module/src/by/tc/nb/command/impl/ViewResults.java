package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

/*public class ViewResults implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        FindNoteByDateRequest req;

        if(request instanceof FindNoteByDateRequest) {

            req = (FindNoteByDateRequest) request;
            TestModuleService nbService = ServiceFactory.getInstance().getTestModuleService();
            FindNoteByDateResponse response = new FindNoteByDateResponse();

            try {
                response.setQuestions(nbService.findNoteByDate(req.getUserID(),req.getDate()));
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Search date found");
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}*/
