package by.tc.nb.command.impl;

import by.tc.nb.bean.AuthorizationRequest;
import by.tc.nb.bean.AuthorizationResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.User;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.UserService;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;

public class Authorize implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        AuthorizationRequest req;

        if (request instanceof AuthorizationRequest) {

            req = (AuthorizationRequest) request;
            AuthorizationResponse response = new AuthorizationResponse();

            String username = req.getUsername();
            String password = req.getPassword();

            UserService userService = ServiceFactory.getInstance().

            try {
                currentUser = userService.logination(username, password);
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            if (currentUser == null) {
                response.setErrorStatus(true);
                response.setErrorMessage("Authentication error, user does not exist!");
                return response;
            } else {
                response.setErrorStatus(false);
                response.setResultMessage("Success");
                response.setUser(currentUser);
                return response;
            }
        } else {
            throw new CommandException("Wrong request");
        }
    }
}