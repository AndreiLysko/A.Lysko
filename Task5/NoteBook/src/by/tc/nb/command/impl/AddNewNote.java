package by.tc.nb.command.impl;

import java.util.Date;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;


public class AddNewNote implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		AddNoteRequest req = null;
		
		if(request instanceof AddNoteRequest){
			req = (AddNoteRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}
		
		String note = req.getNote();

		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();
		
		try {
			nbService.addNote(note, new Date());
		} catch (ServiceException e) {
			throw new CommandException();
		}		
		
		
		Response response = new Response();
		response.setErrorStatus(false);
		response.setResultMessage("All OK!");
		
		
		return response;
	}

}
