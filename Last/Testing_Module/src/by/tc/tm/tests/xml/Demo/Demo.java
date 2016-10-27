package by.tc.tm.tests.xml.Demo;

import by.tc.tm.tests.xml.Data;
import by.tc.tm.tests.xml.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        List<Data> some = new ArrayList<>();

        some = Parser.getPositiveDataList();

        for(Data d: some){
            System.out.println(d.getLogin());
            System.out.println(d.getPassword());
            System.out.println(d.getAnswerNumber());

        }


    }

}
