package by.tc.nb.view;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.controller.Controller;

public class View {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		
		AddNoteRequest request = new AddNoteRequest();
		request.setCommandName("ADD_NEW_NOTE");
		request.setNote("my message");
		
		Response response = controller.doRequest(request);
		
		if(response.isErrorStatus() ==  false){
			System.out.println(response.getErrorMessage());
		}else{
			
		}
		
		
	}

}
