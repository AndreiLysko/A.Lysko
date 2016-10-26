package by.tc.tm.command;

import by.tc.tm.bean.Request;
import by.tc.tm.bean.Response;
import by.tc.tm.command.exception.CommandException;

public interface Command {
    Response execute(Request request) throws CommandException;
}
