package by.tc.nb.utils;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.User;
import by.tc.nb.controller.Controller;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class InterfaceWork {

    private static final Controller controller = new Controller();
    private static final Scanner sc = new Scanner(in);
    private static int sessionId;
    private static final String operations =    "Choose operation: \n"+
                                                "1. Add question \n" +
                                                "2. Find question by content \n" +
                                                "3. Find question by date \n" +
                                                "4. Show all notes \n" +
                                                "5. Clear Notebook \n" +
                                                "0. Exit";
    private static final String startMenu = "-=Notebook v 1.03=- \n" +
                                            "Input command: \n" +
                                            "1. Registration \n" +
                                            "2. Authorization \n" +
                                            "0. Exit \n";

    public static void start() {

        while (true) {
            System.out.println(startMenu);
            String mainMenuChoice = sc.nextLine();
            switch (mainMenuChoice){
                case "1":
                    registration();
                    continue;
                case "2":
                    if(!authorization()) {
                        System.out.println("Incorrect username or password");
                    }
                    else {
                        while (true) {
                            System.out.println(operations);
                            String subMenuChoice = sc.nextLine();
                            switch (subMenuChoice) {
                                case "1":
                                    addQuestion();
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
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Incorrectly inputted command. Try again: ");
                    break;
            }

        }
    }

    private static boolean authorization() {
        AuthorizationRequest request = new AuthorizationRequest();
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        request.setCommandName("AUTHORIZATION");
        request.setPassword(password);
        request.setUsername(username);
        AuthorizationResponse response = (AuthorizationResponse) controller.doRequest(request);
        if (response.isErrorStatus()) {
            System.out.println(response.getErrorMessage());
            return false;
        }
        else{
            User user = response.getUser();
            sessionId = user.getId();
            System.out.println("Welcome , " + user.getUsername() + "!");
            return true;
        }
    }

    private static void registration(){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setCommandName("REGISTRATION");
        System.out.println("Username: ");
        registrationRequest.setUsername(sc.nextLine());
        System.out.println("Password: ");
        registrationRequest.setPassword(sc.nextLine());
        Response response = controller.doRequest(registrationRequest);
        if (response.isErrorStatus()) {
            System.out.println(response.getErrorMessage());
        } else {
            System.out.println("Registration successful");
        }
    }

    private static void addQuestion(){
        System.out.println("Input your question:");

        String content = new Scanner(in).nextLine();

        AddQuestionRequest request = new AddQuestionRequest();
        request.setCommandName("ADD_NEW_QUESTION");
        request.setQuestionText(content);
        request.setUserID(sessionId);

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
        request.setUserID(sessionId);

        ViewNotesResponse response = (ViewNotesResponse) controller.doRequest(request);

        if(response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else {
            if (response.getQuestions().isEmpty()) {
                System.out.println("Notebook is empty");
            }
            else{
                System.out.println(response.getResultMessage());
                response.getQuestions().stream().forEach(note -> System.out.println(note));
            }
        }
    }


    private static void findNoteByContent(){
        try {
            if (!ServiceFactory.getInstance().getTestModuleService().viewNotes(sessionId).isEmpty()) {
                System.out.println("Input search content:");

                String content = new Scanner(in).nextLine();

                FindNoteByContentRequest request = new FindNoteByContentRequest();
                request.setCommandName("FIND_NOTE_BY_CONTENT");
                request.setContent(content);
                request.setUserID(sessionId);

                FindNoteByContentResponse response = (FindNoteByContentResponse) controller.doRequest(request);
                List<Question> notesFound = response.getQuestions();

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
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    private static void findNoteByDate(){
        try {
            if (!ServiceFactory.getInstance().getTestModuleService().viewNotes(sessionId).isEmpty()) {
                System.out.println("Input search date:");

                String date = new Scanner(in).nextLine();

                FindNoteByDateRequest request = new FindNoteByDateRequest();
                request.setCommandName("FIND_NOTE_BY_DATE");
                request.setDate(date);
                request.setUserID(sessionId);

                FindNoteByDateResponse response = (FindNoteByDateResponse) controller.doRequest(request);
                List<Question> notesFound = response.getQuestions();

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
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


    private static void clearNoteBook(){

        ClearNotebookRequest request = new ClearNotebookRequest();

        request.setCommandName("CLEAR_NOTEBOOK");
        request.setUserID(sessionId);

        Response response = controller.doRequest(request);
        if(response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println(response.getResultMessage());
        }
    }

}

