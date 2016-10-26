package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class PassTest implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        PassTestRequest req;

        if(request instanceof PassTestRequest) {

            req = (PassTestRequest) request;
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();
            PassTestResponse response = new PassTestResponse();
            int subject_id = req.getSubject_id();

            try {
                response.setQuestions(testModuleService.passTest(subject_id));
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
