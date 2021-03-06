package tests.dataProvider;

import tests.xml.Parser;
import org.testng.annotations.DataProvider;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DataProviderTM {

    @DataProvider(name = "authorizationPositive")
    public static Object[][] authorizationPositiveTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][2];
        obj[0][0] = Parser.getPositiveDataList().get(0).getLogin();
        obj[0][1] = Parser.getPositiveDataList().get(0).getPassword();

        return obj;
    }

    @DataProvider(name = "authorizationNegative")
    public static Object[][] authorizationNegativeTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][2];
        obj[0][0] = Parser.getNegativeDataList().get(0).getLogin() + String.valueOf(Math.random()*1000);  //login never matches
        obj[0][1] = Parser.getNegativeDataList().get(0).getPassword();

        return obj;
    }

    @DataProvider(name = "registrationPositive")
    public static Object[][] registrationPositiveTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][2];
        obj[0][0] = Parser.getPositiveDataList().get(2).getLogin() + String.valueOf(Math.random()*1000);  //always new login
        obj[0][1] = Parser.getPositiveDataList().get(2).getPassword();

        return obj;
    }

    @DataProvider(name = "registrationNegative")
    public static Object[][] registrationNegativeTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][2];
        obj[0][0] = Parser.getNegativeDataList().get(0).getLogin();
        obj[0][1] = Parser.getNegativeDataList().get(0).getPassword();
//        return new Object[][]{ {Parser.getPositiveDataList().get(0).getLogin() , Parser.getPositiveDataList().get(0).getPassword()}};

        return obj;
    }

    @DataProvider(name = "addQuestionPositive")
    public static Object[][] addQuestionPositiveTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][5];
        obj[0][0] = Parser.getPositiveDataList().get(0).getSubjectID();
        obj[0][1] = Parser.getPositiveDataList().get(0).getSubjectName();
        obj[0][2] = Parser.getPositiveDataList().get(0).getQuestion();
        obj[0][3] = Parser.getPositiveDataList().get(0).getAnswerNumber();
        obj[0][4] = Parser.getPositiveDataList().get(0).getPoints();

        return obj;
    }

    @DataProvider(name = "addQuestionNegative")
    public static Object[][] addQuestionNegativeTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][5];
        obj[0][0] = Parser.getNegativeDataList().get(0).getSubjectID();
        obj[0][1] = Parser.getNegativeDataList().get(0).getSubjectName();
        obj[0][2] = Parser.getNegativeDataList().get(0).getQuestion();
        obj[0][3] = Parser.getNegativeDataList().get(0).getAnswerNumber();
        obj[0][4] = Parser.getNegativeDataList().get(0).getPoints();

        return obj;
    }

    @DataProvider(name = "addSubjectPositive")
    public static Object[][] addSubjectPositiveTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][1];
        obj[0][0] = Parser.getPositiveDataList().get(0).getSubjectName() + Math.random();  //always new subject

        return obj;
    }

    @DataProvider(name = "addSubjectNegative")
    public static Object[][] addSubjectNegativeTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][1];
        obj[0][0] = Parser.getNegativeDataList().get(0).getSubjectName();

        return obj;
    }

    @DataProvider(name = "chooseSubjectPositive")
    public static Object[][] chooseSubjectPositiveTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][1];
        obj[0][0] = Parser.getPositiveDataList().get(0).getSubjectName();

        return obj;
    }

    @DataProvider(name = "passTestPositive")
    public static Object[][] passTestPositiveTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][2];
        obj[0][0] = Parser.getPositiveDataList().get(1).getSubjectID();
        obj[0][1] = Parser.getPositiveDataList().get(1).getSubjectName();

        return obj;
    }

    @DataProvider(name = "passTestNegative")
    public static Object[][] passTestNegativeTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][2];
        obj[0][0] = Parser.getNegativeDataList().get(0).getSubjectID();
        obj[0][1] = Parser.getNegativeDataList().get(0).getSubjectName();

        return obj;
    }

    @DataProvider(name = "showResultsPositive")
    public static Object[][] showResultsPositiveTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][4];
        obj[0][0] = Parser.getPositiveDataList().get(0).getUserID();
        obj[0][1] = Parser.getPositiveDataList().get(0).getSubjectID();
        obj[0][2] = Parser.getPositiveDataList().get(0).getSubjectName();
        obj[0][3] = Parser.getPositiveDataList().get(0).getPoints();

        return obj;
    }

    @DataProvider(name = "showResultsException")
    public static Object[][] showResultsNegativeTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][1];
        obj[0][0] = Parser.getNegativeDataList().get(0).getUserID();

        return obj;
    }

    @DataProvider(name = "writeResultsPositive")
    public static Object[][] writeResultsPositiveTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][4];
        obj[0][0] = Parser.getPositiveDataList().get(0).getUserID();
        obj[0][1] = Parser.getPositiveDataList().get(0).getSubjectID();
        obj[0][2] = Parser.getPositiveDataList().get(0).getSubjectName();
        obj[0][3] = Parser.getPositiveDataList().get(0).getPoints();

        return obj;
    }

    @DataProvider(name = "writeResultsNegative")
    public static Object[][] writeResultsNegativeTest() throws SAXException, IOException, ParserConfigurationException {
        Object obj[][] = new Object[1][4];
        obj[0][0] = Parser.getNegativeDataList().get(0).getUserID();
        obj[0][1] = Parser.getNegativeDataList().get(0).getSubjectID();
        obj[0][2] = Parser.getNegativeDataList().get(0).getSubjectName();
        obj[0][3] = Parser.getNegativeDataList().get(0).getPoints();

        return obj;
    }
}
