package tests.xml;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

//    private static List<Data> positiveDataList = new ArrayList<Data>();
//    private static List<Data> negativeDataList = new ArrayList<Data>();

    private static Element getTests() throws IOException, SAXException, ParserConfigurationException {

        DOMParser parser = new DOMParser();
        parser.parse("..\\Testing_Module\\src\\tests\\xml\\data.xml");
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        return root;
    }

    private static Element getSingleChild(Element element, String childName){
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

    public static List<Data> getPositiveDataList() throws IOException, SAXException, ParserConfigurationException {

        NodeList positive;
        Element root = getTests();

        List<Data> positiveDataList = new ArrayList<>();
        positiveDataList.clear();
        positive = root.getElementsByTagName("positive_test");

        for (int i = 0; i <positive.getLength(); i++){
            Data positiveData = new Data();
            Element element = (Element)positive.item(i);
            positiveData.setUserID(Integer.parseInt((getSingleChild(element, "userID")).getTextContent().trim()));
            positiveData.setLogin(getSingleChild(element,"login").getTextContent().trim());
            positiveData.setPassword(getSingleChild(element,"password").getTextContent().trim());
            positiveData.setSubjectID(Integer.parseInt((getSingleChild(element,"subjectID")).getTextContent().trim()));
            positiveData.setSubjectName(getSingleChild(element,"subjectName").getTextContent().trim());
            positiveData.setQuestion(getSingleChild(element,"question").getTextContent().trim());
            positiveData.setAnswerNumber(Integer.parseInt((getSingleChild(element, "answerNumber")).getTextContent().trim()));
            positiveData.setPoints(Integer.parseInt((getSingleChild(element, "points")).getTextContent().trim()));
            positiveDataList.add(positiveData);
        }

        return positiveDataList;
    }

    public static List<Data> getNegativeDataList() throws IOException, SAXException, ParserConfigurationException {

        NodeList negative;
        Element root = getTests();

        List<Data> negativeDataList = new ArrayList<>();
        negativeDataList.clear();
        negative = root.getElementsByTagName("negative_test");

        for (int i = 0; i <negative.getLength(); i++){
            Data negativeData = new Data();
            Element element = (Element)negative.item(i);
            negativeData.setUserID(Integer.parseInt((getSingleChild(element, "userID")).getTextContent().trim()));
            negativeData.setLogin(getSingleChild(element,"login").getTextContent().trim());
            negativeData.setPassword(getSingleChild(element,"password").getTextContent().trim());
            negativeData.setSubjectID(Integer.parseInt((getSingleChild(element,"subjectID")).getTextContent().trim()));
            negativeData.setSubjectName(getSingleChild(element,"subjectName").getTextContent().trim());
            negativeData.setQuestion(getSingleChild(element,"question").getTextContent().trim());
            negativeData.setAnswerNumber(Integer.parseInt((getSingleChild(element, "answerNumber")).getTextContent().trim()));
            negativeData.setPoints(Integer.parseInt((getSingleChild(element, "points")).getTextContent().trim()));
            negativeDataList.add(negativeData);
        }

        return negativeDataList;
    }
}
