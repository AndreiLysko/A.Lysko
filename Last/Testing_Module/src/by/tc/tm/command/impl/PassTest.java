package by.tc.tm.command.impl;

import by.tc.tm.bean.*;
import by.tc.tm.command.Command;
import by.tc.tm.command.exception.CommandException;
import by.tc.tm.service.TestModuleService;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.exception.ServiceException;

public class PassTest implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        PassTestRequest req;

        if(request instanceof PassTestRequest) {

            req = (PassTestRequest) request;
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();
            PassTestResponse response = new PassTestResponse();

            try {
                response.setQuestions(testModuleService.passTest(req.getSubject_id(),req.getSubject_name()));
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Test started");
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
