package by.tc.tm.tests;

import by.tc.tm.bean.entity.Subject;
import by.tc.tm.bean.entity.User;
import by.tc.tm.dao.QuestionsDAOFactory;
import by.tc.tm.dao.UserDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.exception.ServiceException;
import by.tc.tm.tests.dataProvider.DataProviderTM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class AddQuestionTest {

    @Test(dataProvider = "addQuestionPositive", dataProviderClass = DataProviderTM.class)
    public void positiveTest(int subject_ID, String subject_name, String question, int answerNumber, int points) throws DAOException, SAXException, IOException, ServiceException {

        boolean actual = ServiceFactory.getInstance().getTestModuleService().addQuestion(subject_ID, subject_name, question, answerNumber, points);

        Assert.assertTrue(actual);

    }

    @Test(expectedExceptions = { ServiceException.class },dataProvider = "addQuestionNegative", dataProviderClass = DataProviderTM.class)
    public void exceptionTest(int subject_ID, String subject_name, String question, int answerNumber, int points) throws ServiceException {

        boolean actual = ServiceFactory.getInstance().getTestModuleService().addQuestion(subject_ID, subject_name, question, answerNumber, points);

        Assert.assertFalse(actual);

    }

}