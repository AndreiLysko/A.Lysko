package by.tc.nb.view;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Subjects;
import by.tc.nb.bean.entity.Test;
import by.tc.nb.bean.entity.User;
import by.tc.nb.controller.Controller;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.utils.check.Validate;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class InterfaceWork {

    private static final Controller controller = new Controller();
    private static final Scanner sc = new Scanner(in);
    private static boolean flag = true;
    private static int subjectID = -1;
    private static int sessionId;
    private static int privileges;
    private static int successPercentage;
    private static final String tutorOperations =    "Choose operation: \n"+
                                                        "1. Add new question \n" +
                                                        "2. Choose subject \n" +
                                                        "3. Add question to existing subject \n" +
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
                                        addNewQuestion();
                                        break;
                                    case "2":
                                        chooseSubject();
                                        break;
                                    case "3":
                                        addQuestionWithSubject();
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
                                 //       showResults();
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

    private static void chooseSubject(){
        System.out.println("Choose subject:");
        for (int i = 0; i < Subjects.values().length; i++) {
            System.out.println((i+1) + ". " + Subjects.values()[i]);
        }
        Scanner sc = new Scanner(in);
        while (true) {
            String subject = sc.nextLine();
            if (Validate.integer(subject)){
                if (0 <= Integer.parseInt(subject)&& Integer.parseInt(subject) < Subjects.values().length){
                    subjectID = Integer.parseInt(subject) - 1;
                    break;
            }
            }
            else{
                System.out.println("Incorrect choice");
            }
        }
    }

    private static void addNewQuestion(){
        chooseSubject();
        addQuestionWithSubject();
    }

    private static void addQuestionWithSubject(){
        System.out.println("Input question (with answers):");

        String questionText = sc.nextLine();

        System.out.println("Input number of answer");

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
        request.setPoints(Integer.parseInt(pointsForQuestion));
        request.setQuestionText(questionText);
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
        //            if (!ServiceFactory.getInstance().getTestModuleService().viewNotes(sessionId).isEmpty()) {

        if (subjectID < 0){
            chooseSubject();
        }
        PassTestRequest request = new PassTestRequest();
        request.setCommandName("PASS_TEST");
        request.setSubject_id(subjectID);

        PassTestResponse response = (PassTestResponse) controller.doRequest(request);
        List<Question> questions = response.getQuestions();

        System.out.println("Test " + Subjects.values()[subjectID]);
        String answers;
        int totalPoints = 0;
        int points = 0;
        float percentage = 0;

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

}

