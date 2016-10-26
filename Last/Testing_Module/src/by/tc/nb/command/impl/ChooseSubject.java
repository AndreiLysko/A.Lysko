package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.exception.ServiceException;

public class ChooseSubject implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        ChooseSubjectRequest req;

        if (request instanceof ChooseSubjectRequest) {

            ChooseSubjectResponse response = new ChooseSubjectResponse();
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();


            try {
                response.setSubjects(testModuleService.chooseSubject());
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Subject chosen");
            return response;
        }
        else {
            throw new CommandException("Incorrect request");
        }
    }
}
