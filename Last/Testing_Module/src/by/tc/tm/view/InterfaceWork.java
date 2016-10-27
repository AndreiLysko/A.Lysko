package by.tc.tm.view;

import by.tc.tm.bean.*;
import by.tc.tm.bean.entity.*;
import by.tc.tm.controller.Controller;
import by.tc.tm.utils.check.Validate;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class InterfaceWork {

    private static final Controller controller = new Controller();
    private static final Scanner sc = new Scanner(in);
    private static boolean flag = true;
    private static int subjectID;
    private static String subjectName;
    private static int sessionId;
    private static int privileges;
    private static int successPercentage;
    private static final String tutorOperations =    "Choose operation: \n"+
                                                        "1. Add subject \n" +
                                                        "2. Choose subject \n" +
                                                        "3. Add question \n" +
                                                        "0. Back";

    private static final String studentOperations = "Choose operation: \n"+
                                                    "1. Choose subject \n" +
                                                    "2. Pass test \n" +
                                                    "3. Show results \n" +
                                                    "0. Back";

    private static final String startMenu = "-=Notebook v 1.03=- \n" +
                                            "Input command: \n" +
                                            "1. Registration \n" +
                                            "2. Authorization \n" +
                                            "0. Exit ";

    public static void start() {

        while (true) {
            System.out.println(startMenu);
            String mainMenuChoice = sc.nextLine();
            flag = true;
            switch (mainMenuChoice){
                case "1":
                    registration();
                    continue;
                case "2":
                    if(!authorization()) {
                        System.out.println("Incorrect username or password");
                    }
                    else {
                        if (privileges > 0) {
                            while (flag) {
                                System.out.println(tutorOperations);
                                String subMenuChoice = sc.nextLine();
                                switch (subMenuChoice) {
                                    case "1":
                                        addSubject();
                                        break;
                                    case "2":
                                        chooseSubject();
                                        break;
                                    case "3":
                                        addQuestion();
                                        break;
                                    case "0":
                                        flag = false;
                                        break;
                                    default:
                                        System.out.println("Incorrectly inputted command. Try again: ");
                                        break;
                                }
                            }
                        } else {
                            while (flag) {
                                System.out.println(studentOperations);
                                String subMenuChoice = sc.nextLine();
                                switch (subMenuChoice) {
                                    case "1":
                                        chooseSubject();
                                        break;
                                    case "2":
                                        passTest();
                                        break;
                                    case "3":
                                        showResults();
                                        break;
                                    case "0":
                                        flag = false;
                                        break;
                                    default:
                                        System.out.println("Incorrectly inputted command. Try again: ");
                                        break;
                                }
                            }
                        }
                    }
                    break;
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
            privileges = user.getPriviledge();
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

    private static void addSubject(){

        AddSubjectRequest request = new AddSubjectRequest();
        request.setCommandName("ADD_SUBJECT");
        System.out.println("Input name of subject to add: ");
        request.setSubject_name(sc.nextLine().toLowerCase());
        AddSubjectResponse response = (AddSubjectResponse)controller.doRequest(request);
        if (response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println("Added successfully");
        }
    }

    private static void chooseSubject(){
        ChooseSubjectRequest chooseSubjectRequest = new ChooseSubjectRequest();
        chooseSubjectRequest.setCommandName("CHOOSE_SUBJECT");
        ChooseSubjectResponse response = (ChooseSubjectResponse)controller.doRequest(chooseSubjectRequest);
        int i = 1;
        List<Subject> subjects = response.getSubjects();
        for (Subject s : subjects){
            System.out.println(i + ". " + s.getSubject_name().toUpperCase());
            i++;
        }
        System.out.println("Enter your choice: ");
        String choice;
        while (true){
            choice = sc.nextLine();
            if (Validate.integer(choice) && Integer.parseInt(choice) <= subjects.size()){
                break;
            }
            System.out.println("Incorrect input");
        }
        subjectID = subjects.get(Integer.parseInt(choice) - 1).getSubjectID();
        subjectName = subjects.get(Integer.parseInt(choice) - 1).getSubject_name();

    }


    private static void addQuestion(){

        StringBuilder sb = new StringBuilder();
        String check;

        System.out.println("Input question :");
        sb.append(sc.nextLine() + "\n");

        System.out.println("Input answers count");
        while (true){
            check = sc.nextLine();
            if (Validate.integer(check)){
                break;
            }
            System.out.println("Incorrect input");
        }


        System.out.println("Input answers :");
        int i;
        for (i = 1; i <= Integer.parseInt(check); i++){
            System.out.println("Answer " + i);
            sb.append("\n" + i + ". " + sc.nextLine());
        }

        System.out.println("Input number of right answer");
        String answerNumber;

        while (true){
            answerNumber = sc.nextLine();
            if (Validate.integer(answerNumber)){
                break;
            }
            System.out.println("Incorrect input");
        }

        System.out.println("Input points for question");

        String pointsForQuestion;
        while (true){
            pointsForQuestion = sc.nextLine();
            if (Validate.integer(pointsForQuestion)){
                break;
            }
            System.out.println("Incorrect input");
        }

        AddQuestionRequest request = new AddQuestionRequest();
        request.setCommandName("ADD_NEW_QUESTION");
        request.setSubjectID(subjectID);
        request.setSubjectName(subjectName);
        request.setPoints(Integer.parseInt(pointsForQuestion));
        request.setQuestionText(sb.toString());
        request.setAnswerNumber(Integer.parseInt(answerNumber));

        Response response = controller.doRequest(request);
        if(response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else{
            System.out.println(response.getResultMessage());
        }
    }

    private static void writeResults(){

        WriteResultsRequest request = new WriteResultsRequest();
        request.setCommandName("WRITE_RESULTS");
        request.setOwner_id(sessionId);
        request.setSubject_id(subjectID);
        request.setPoints(successPercentage);
        request.setSubject_name(subjectName);

        WriteResultsResponse response = (WriteResultsResponse) controller.doRequest(request);
        Test test = response.getTest();
        if (response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
        else {
            System.out.println("Result of test has been written \n" + test.toString());
        }
    }

    private static void passTest(){

        if (subjectID < 1){
            chooseSubject();
        }
        PassTestRequest request = new PassTestRequest();
        request.setCommandName("PASS_TEST");
        request.setSubject_id(subjectID);
        request.setSubject_name(subjectName);

        PassTestResponse response = (PassTestResponse) controller.doRequest(request);
        List<Question> questions = response.getQuestions();

        System.out.println("TEST " + subjectName.toUpperCase());
        String answers;
        int totalPoints = 0;
        int points = 0;

        if (!questions.isEmpty()) {
            System.out.println(response.getResultMessage());
            for (Question q : questions){
                System.out.println(q.getText());
                answers = sc.nextLine();
                if (Integer.parseInt(answers) == q.getAnswer()){
                    points += q.getPoints();
                    totalPoints += q.getPoints();
                    System.out.println("correct");
                }
                else {
                    System.out.println("incorrect");
                    totalPoints += q.getPoints();
                }
            }
            successPercentage = (points*100)/totalPoints;
            System.out.println("Your point is "+ successPercentage + "%");

        } else {
            System.out.println("No questions have been found");
        }
        if (response.isErrorStatus()) {
            System.out.println(response.getErrorMessage());
        }
        else {
            writeResults();
        }
    }

    private static void showResults(){

        ShowResultsRequest request = new ShowResultsRequest();
        request.setCommandName("SHOW_RESULTS");
        request.setUser_id(sessionId);

        ShowResultsResponse response = (ShowResultsResponse) controller.doRequest(request);
        List<Test> tests = response.getTests();

        for(Test t : tests){
            System.out.println(t.toString());
        }
    }

}

