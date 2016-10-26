package by.tc.tm.command.impl;

import by.tc.tm.bean.AuthorizationRequest;
import by.tc.tm.bean.AuthorizationResponse;
import by.tc.tm.bean.Request;
import by.tc.tm.bean.Response;
import by.tc.tm.bean.entity.User;
import by.tc.tm.command.Command;
import by.tc.tm.command.exception.CommandException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.UserService;
import by.tc.tm.service.exception.ServiceException;

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