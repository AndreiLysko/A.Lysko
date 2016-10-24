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

public class Authorize implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        AuthorizationRequest req;

        if (request instanceof AuthorizationRequest) {

            req = (AuthorizationRequest) request;
            AuthorizationResponse response = new AuthorizationResponse();

            String username = req.getUsername();
            String password = req.getPassword();
            User user;

            UserService userService = ServiceFactory.getInstance().getUserService();

            try {
                user = userService.authorization(username,password);
            } catch (ServiceException e) {
                response.setErrorStatus(true);
                response.setErrorMessage(e.getMessage());
                return response;
            }

            if(user == null) {
                response.setErrorStatus(true);
                response.setErrorMessage("User does not exists");
                return response;
            } else {
                response.setErrorStatus(false);
                response.setResultMessage("Authorization successful");
                response.setUser(user);
                return response;
            }
        } else {
            throw new CommandException("Incorrect request");
        }
    }
}