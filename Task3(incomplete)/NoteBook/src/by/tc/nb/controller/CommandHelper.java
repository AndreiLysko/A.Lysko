package by.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;

import by.tc.nb.command.Command;
import by.tc.nb.command.impl.AddNote;
import by.tc.nb.command.impl.FindNotes;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("ADD_NEW_NOTE", new AddNote());
		commands.put("FIND_NOTES", new FindNotes());

	}

	public Command getCommand(String commandName) {
		Command command;

		command = commands.get(commandName);

		return command;

	}

}
