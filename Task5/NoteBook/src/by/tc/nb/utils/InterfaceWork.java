package by.tc.nb.utils;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class InterfaceWork {

    private static final Controller controller = new Controller();
    private static final Scanner sc = new Scanner(in);
    private static final String operations =    "Choose operation: \n"+
                                                "1. Add note \n" +
                                                "2. Find note by content \n" +
                                                "3. Find note by date \n" +
                                                "4. Show all notes \n" +
                                                "5. Clear Notebook \n" +
                                                "0. Exit";
    private static final String startMenu ="-=Notebook v 1.03=- \n" +
            "Input command: \n" +
            "1. Registration \n" +
            "2. Authorization \n" +
            "0. Exit \n";

    public static void start() {

        while (true) {
            String mainMenuChoice = sc.nextLine();
            switch (mainMenuChoice){
                case "1":
                    registration();
                    continue;
                case "2":
                    authorization();
                    while (true){
                        String subMenuChoice = sc.nextLine();
                        switch (subMenuChoice) {
                            case "1":
                                addNote();
                                break;
                            case "2":
                                findNoteByContent();
                                break;
                            case "3":
                                findNoteByDate();
                                break;
                            case "4":
                                viewNotes();
                                break;
                            case "5":
                                clearNoteBook();
                                break;
                            case "0":
                                System.exit(0);
                            default:
                                System.out.println("Incorrectly inputted command. Try again: ");
                                break;
                        }
                    }
            }

        }
    }

    private static void authorization(){

    }

    private static void registration(){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setCommandName("REGISTRATION");
        System.out.println("Username: ");
        registrationRequest.setUsername(sc.nextLine());
        System.out.println("Password: ");
        registrationRequest.setPassword(sc.nextLine());
        Response registrationResponce = controller.doRequest(registrationRequest);
        if (registrationResponce.isErrorStatus()) {
            System.out.println(registrationResponce.getErrorMessage());
        } else {
            System.out.println("Registration successful");
        }
    }
    private static void addNote(){
        System.out.println("Input your note:");

        String content = new Scanner(in).nextLine();
        String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        AddNoteRequest request = new AddNoteRequest();
        request.setCommandName("ADD_NEW_NOTE");
        request.setNote(content);
        request.setCreationDate(date);

        Response response = controller.doRequest(request);
        if(response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println(response.getResultMessage());
        }
    }

    private static void viewNotes(){

        ViewNotesRequest request = new ViewNotesRequest();
        request.setCommandName("VIEW_ALL_NOTES");

        ViewNotesResponse response;
        response = (ViewNotesResponse) controller.doRequest(request);

        if(response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else {
            if (response.getNotes().isEmpty()) {
                System.out.println("Notebook is empty");
            }
        }
    }


    private static void findNoteByContent(){
        if (!NoteBookProvider.getInstance().getNoteBook().getNotes().isEmpty()) {
            System.out.println("Input search content:");

            String content = new Scanner(in).nextLine();

            FindNoteByContentRequest request = new FindNoteByContentRequest();
            request.setCommandName("FIND_NOTE_BY_CONTENT");
            request.setContent(content);

            FindNoteByContentResponse response = (FindNoteByContentResponse) controller.doRequest(request);
            List<Note> notesFound = response.getNotes();

            System.out.println("Searching " + content);
            if (!notesFound.isEmpty()) {
                System.out.println(response.getResultMessage());
                notesFound.stream().forEach(note -> System.out.println(note));
            } else {
                System.out.println("No notes have been found");
            }
            if (response.isErrorStatus()) {
                System.out.println(response.getErrorMessage());
            }
        }
        else {
            System.out.println("Notebook is empty");
        }
    }

    private static void findNoteByDate(){
        if (!NoteBookProvider.getInstance().getNoteBook().getNotes().isEmpty()) {
            System.out.println("Input search date:");

            String date = new Scanner(in).nextLine();

            FindNoteByDateRequest request = new FindNoteByDateRequest();
            request.setCommandName("FIND_NOTE_BY_DATE");
            request.setDate(date);

            FindNoteByDateResponse response = (FindNoteByDateResponse) controller.doRequest(request);
            List<Note> notesFound = response.getNotes();

            System.out.println("Searching " + date);
            if (!notesFound.isEmpty()) {
                System.out.println(response.getResultMessage());
                notesFound.stream().forEach(note -> System.out.println(note));
            } else {
                System.out.println("No notes have been found for that date");
            }
            if (response.isErrorStatus()) {
                System.out.println(response.getErrorMessage());
            }
        }
        else {
            System.out.println("Notebook is empty");
        }
    }


    private static void clearNoteBook(){
        ClearNotebookRequest request = new ClearNotebookRequest();
        request.setCommandName("CLEAR_NOTEBOOK");

        Response response = controller.doRequest(request);
        if(response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println(response.getResultMessage());
        }
    }

}

