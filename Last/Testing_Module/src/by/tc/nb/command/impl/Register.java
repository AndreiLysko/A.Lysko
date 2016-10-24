package by.tc.nb.command.impl;

import by.tc.nb.bean.AuthorizationResponse;
import by.tc.nb.bean.RegistrationRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.UserService;
import by.tc.nb.service.exception.ServiceException;

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
