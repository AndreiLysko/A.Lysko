package by.tc.nb.command.impl;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.NBUtilities;

public class AddNote implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		AddNoteRequest req;
		
		if(request instanceof AddNoteRequest){
			req = (AddNoteRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}
		
		String note = req.getNote();
		String creationDate = req.getCreationDate();
		
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		NBUtilities.addNote(noteBook,new Note(note,creationDate));

		Response response = new Response();
		response.setErrorStatus(false);
		response.setResultMessage("Note has been successfully added");
		
		
		return response;
	}

}
