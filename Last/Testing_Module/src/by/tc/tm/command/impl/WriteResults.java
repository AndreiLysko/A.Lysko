package by.tc.tm.command.impl;

import by.tc.tm.bean.*;
import by.tc.tm.command.Command;
import by.tc.tm.command.exception.CommandException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.TestModuleService;
import by.tc.tm.service.exception.ServiceException;

public class WriteResults implements Command{

    @Override
    public Response execute(Request request) throws CommandException {
        WriteResultsRequest req;

        if(request instanceof WriteResultsRequest) {

            req = (WriteResultsRequest) request;
            TestModuleService testModuleService = ServiceFactory.getInstance().getTestModuleService();
            WriteResultsResponse response = new WriteResultsResponse();
            int subject_id = req.getSubject_id();
            String subject_name = req.getSubject_name();
            int owner_id = req.getOwner_id();
            int points = req.getPoints();


            try {
                response.setTest(testModuleService.writeResults(owner_id,subject_id, subject_name,points));
            }
            catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("Result has been written");
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
