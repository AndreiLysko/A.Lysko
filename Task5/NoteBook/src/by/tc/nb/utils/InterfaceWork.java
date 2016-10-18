package by.tc.nb.utils;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;
import by.tc.nb.source.NoteBookProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InterfaceWork {

    private static final Controller controller = new Controller();
    private static final Scanner sc = new Scanner(System.in);

    public static void start() {
        System.out.println("-=Notebook v1.01=-\n" +
                            "Choose operation: \n"+
                            "1. Add note \n" +
                            "2. Find note by content \n" +
                            "3. Find note by date \n" +
                            "4. Show all notes \n" +
                            "5. Clear Notebook \n" +
                            "6. Load notes from file \n" +
                            "7. Write note to file \n"  +
                            "8. Serialize Notebook \n"  +
                            "9. Deserialize Notebook \n"  +
                            "0. Exit");

        while (true) {
            String choice = sc.nextLine();
            switch (choice) {
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
                case "6":
                    loadNotebookFromFile();
                    break;
                case "7":
                    writeNotebookToFile();
                    break;
                case "8":
                    serializeNotebook();
                    break;
                case "9":
                    deserializeNotebook();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Incorrectly inputted command. Try again: ");
                    break;
            }
        }
    }

    private static void addNote(){
        System.out.println("Input your note:");

        String content = new Scanner(System.in).nextLine();
        String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        AddNoteRequest request = new AddNoteRequest();
        request.setCommandName("ADD_NEW_NOTE");
        request.setData(content);
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

            String content = new Scanner(System.in).nextLine();

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

            String date = new Scanner(System.in).nextLine();

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

    private static void loadNotebookFromFile(){
        String filePath = "notebook.txt";

        LoadNotebookFromFileRequest request = new LoadNotebookFromFileRequest();
        request.setCommandName("LOAD_NOTEBOOK_FROM_FILE");
        request.setFilePath(filePath);

        Response response = controller.doRequest(request);
        if(response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println(response.getResultMessage());
        }
    }

    private static void writeNotebookToFile(){
        String filePath = "notebook.txt";

        WriteNotebookToFileRequest request = new WriteNotebookToFileRequest();
        request.setCommandName("WRITE_NOTEBOOK_TO_FILE");
        request.setFilePath(filePath);

        Response response = controller.doRequest(request);
        if(response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println(response.getResultMessage());
        }
    }

    private static void serializeNotebook(){
        String pathSerialize = "notebookSerialize.txt";
        SerializeNotebookRequest request = new SerializeNotebookRequest();
        request.setCommandName("SERIALIZE_NOTEBOOK");
        request.setFilePath(pathSerialize);
        Response response = controller.doRequest(request);
        if (response.isErrorStatus()) {
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println(response.getResultMessage());
        }
    }

    private static void deserializeNotebook(){
        String pathOutSerialize = "notebookSerialize.txt";
        DeserializeNotebookRequest request = new DeserializeNotebookRequest();
        request.setCommandName("DESERIALIZE_NOTEBOOK");
        request.setFilePath(pathOutSerialize);
        Response response = controller.doRequest(request);
        if (response.isErrorStatus()) {
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println(response.getResultMessage());
        }
    }

}

