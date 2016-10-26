package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.exception.ServiceException;

public class ShowResults implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        ShowResultsRequest req;

        if(request instanceof ShowResultsRequest) {

            req = (ShowResultsRequest) request;
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();
            ShowResultsResponse response = new ShowResultsResponse();
            int user_id = req.getUser_id();

            try {
                response.setTests();
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Results are shown");
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
