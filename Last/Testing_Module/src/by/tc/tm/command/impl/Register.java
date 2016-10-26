package by.tc.tm.command.impl;

import by.tc.tm.bean.AuthorizationResponse;
import by.tc.tm.bean.RegistrationRequest;
import by.tc.tm.bean.Request;
import by.tc.tm.bean.Response;
import by.tc.tm.command.Command;
import by.tc.tm.command.exception.CommandException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.UserService;
import by.tc.tm.service.exception.ServiceException;

public class Register implements Command{
    @Override
    public Response execute(Request request) throws CommandException {
        RegistrationRequest req;

        if (request instanceof RegistrationRequest) {

            req = (RegistrationRequest) request;
            AuthorizationResponse response = new AuthorizationResponse();

            String username = req.getUsername();
            String password = req.getPassword();

            UserService userService = ServiceFactory.getInstance().getUserService();

            try {
                userService.registration(username, password);
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            response.setErrorStatus(false);
            response.setResultMessage("User has been successfully registered");
            return response;
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}
