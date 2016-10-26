package by.tc.tm.controller;

import by.tc.tm.bean.Request;
import by.tc.tm.bean.Response;
import by.tc.tm.command.Command;
import by.tc.tm.command.exception.CommandException;

public class Controller {

    private CommandHelper helper = new CommandHelper();

    public Controller() {
    }

    public Response doRequest(Request request)  {

        String commandName = request.getCommandName();
        Command command = helper.getCommand(commandName);
        Response response;

        try {
            response = command.execute(request);
        } catch (CommandException e) {
            response = new Response();
            response.setErrorStatus(true);
            response.setErrorMessage("Error occured");
        }
        return response;

    }

}
