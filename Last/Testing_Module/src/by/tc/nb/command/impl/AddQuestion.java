package by.tc.nb.command.impl;

import by.tc.nb.bean.AddQuestionRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class AddQuestion implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        AddQuestionRequest req;

        if (request instanceof AddQuestionRequest) {

            req = (AddQuestionRequest) request;
            Response response = new Response();
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();


            try {
                testModuleService.addQuestion(req.getSubjectID(),req.getQuestionText(),req.getAnswerNumber(),req.getPoints());
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Here is your test");
            return response;
        }
        else {
            throw new CommandException("Incorrect request");
        }
    }

}
