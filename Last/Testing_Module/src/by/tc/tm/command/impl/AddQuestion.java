package by.tc.tm.command.impl;

import by.tc.tm.bean.AddQuestionRequest;
import by.tc.tm.bean.Request;
import by.tc.tm.bean.Response;
import by.tc.tm.command.Command;
import by.tc.tm.command.exception.CommandException;
import by.tc.tm.service.TestModuleService;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.exception.ServiceException;

public class AddQuestion implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        AddQuestionRequest req;

        if (request instanceof AddQuestionRequest) {

            req = (AddQuestionRequest) request;
            Response response = new Response();
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();


            try {
                testModuleService.addQuestion(req.getSubjectID(),req.getSubjectName(),req.getQuestionText(),req.getAnswerNumber(),req.getPoints());
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Question added");
            return response;
        }
        else {
            throw new CommandException("Incorrect request");
        }
    }

}
