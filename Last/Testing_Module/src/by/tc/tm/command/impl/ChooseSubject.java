package by.tc.tm.command.impl;

import by.tc.tm.bean.*;
import by.tc.tm.command.Command;
import by.tc.tm.command.exception.CommandException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.TestModuleService;
import by.tc.tm.service.exception.ServiceException;

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
