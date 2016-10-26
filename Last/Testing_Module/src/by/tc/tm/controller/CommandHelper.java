package by.tc.tm.controller;

import by.tc.tm.command.Command;
import by.tc.tm.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private Map<String, Command> commands = new HashMap<String, Command>();

    public CommandHelper() {

        commands.put("ADD_NEW_QUESTION", new AddQuestion());
        commands.put("ADD_SUBJECT", new AddSubject());
        commands.put("WRITE_RESULTS", new WriteResults());
        commands.put("PASS_TEST", new PassTest());
        commands.put("CHOOSE_SUBJECT", new ChooseSubject());
        commands.put("AUTHORIZATION", new Authorize());
        commands.put("REGISTRATION", new Register());
        commands.put("SHOW_RESULTS", new ShowResults());

    }

    public Command getCommand(String commandName) {
        Command command;

        command = commands.get(commandName);

        return command;

    }

}
