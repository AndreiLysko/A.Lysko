package by.tc.nb.controller;

import by.tc.nb.command.Command;
import by.tc.nb.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private Map<String, Command> commands = new HashMap<String, Command>();

    public CommandHelper() {

        commands.put("ADD_NEW_NOTE", new AddNote());
        commands.put("VIEW_ALL_NOTES", new ViewNotes());
        commands.put("CLEAR_NOTEBOOK", new ClearNotebook());
        commands.put("FIND_NOTE_BY_CONTENT", new FindNoteByContent());
        commands.put("FIND_NOTE_BY_DATE", new FindNoteByDate());
        commands.put("LOAD_NOTEBOOK_FROM_FILE", new LoadNotebookFromFile());
        commands.put("WRITE_NOTEBOOK_TO_FILE", new WriteNotebookToFile());
        commands.put("SERIALIZE_NOTEBOOK", new SerializeNotebook());
        commands.put("DESERIALIZE_NOTEBOOK", new DeserializeNotebook());

    }

    public Command getCommand(String commandName) {
        Command command;

        command = commands.get(commandName);

        return command;

    }

}
