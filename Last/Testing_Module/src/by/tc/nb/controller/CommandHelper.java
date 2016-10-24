package by.tc.nb.controller;

import by.tc.nb.command.Command;
import by.tc.nb.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private Map<String, Command> commands = new HashMap<String, Command>();

    public CommandHelper() {

        commands.put("ADD_NEW_QUESTION", new AddQuestion());
        commands.put("VIEW_ALL_SUBJECTS", new ViewSubjects());
        commands.put("CLEAR_NOTEBOOK", new ClearNotebook());
        commands.put("PERFORM_TEST", new PerformTest());
        commands.put("VIEW_MY_RESULTS", new ViewResults());
        commands.put("AUTHORIZATION", new Authorize());
        commands.put("REGISTRATION", new Register());

    }

    public Command getCommand(String commandName) {
        Command command;

        command = commands.get(commandName);

        return command;

    }

}
