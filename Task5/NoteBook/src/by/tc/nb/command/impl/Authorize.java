package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

import java.io.IOException;

public class Authorize implements Command {

    @Override
    public Response execute(Request request) throws CommandException{
        return null;
    }
}
