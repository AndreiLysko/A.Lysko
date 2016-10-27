package by.tc.tm.tests;

import by.tc.tm.bean.entity.Subject;
import by.tc.tm.dao.QuestionsDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.exception.ServiceException;
import by.tc.tm.tests.dataProvider.DataProviderTM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class ChooseSubjectTest {

    @Test(dataProvider = "chooseSubjectPositive", dataProviderClass = DataProviderTM.class)
    public void positiveTest(String subject_name) throws DAOException, SAXException, IOException {

        QuestionsDAOFactory.getInstance().getQuestionsDAO().addSubject(subject_name);

        List<Subject> actual = QuestionsDAOFactory.getInstance().getQuestionsDAO().chooseSubject();

        Assert.assertFalse(actual.isEmpty());

    }

}