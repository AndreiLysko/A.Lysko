package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.exception.ServiceException;

public class AddSubject implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        AddSubjectRequest req;

        if (request instanceof AddSubjectRequest) {

            req = (AddSubjectRequest) request;
            AddSubjectResponse response = new AddSubjectResponse();
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();


            try {
                testModuleService.addSubject(req.getSubject_name());
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Subject added");
            return response;
        }
        else {
            throw new CommandException("Incorrect request");
        }
    }
}
