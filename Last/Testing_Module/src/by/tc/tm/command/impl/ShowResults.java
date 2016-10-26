package by.tc.tm.command.impl;

import by.tc.tm.bean.*;
import by.tc.tm.command.Command;
import by.tc.tm.command.exception.CommandException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.TestModuleService;
import by.tc.tm.service.exception.ServiceException;

public class ShowResults implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        ShowResultsRequest req;

        if(request instanceof ShowResultsRequest) {

            req = (ShowResultsRequest) request;
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();
            ShowResultsResponse response = new ShowResultsResponse();

            try {
                response.setTests(testModuleService.showResults(req.getUser_id()));
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
