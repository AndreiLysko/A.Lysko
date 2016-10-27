package tests;

import by.tc.tm.bean.entity.Subject;
import by.tc.tm.dao.QuestionsDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.exception.ServiceException;
import tests.dataProvider.DataProviderTM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class AddSubjectTest {

    @Test(dataProvider = "addSubjectPositive", dataProviderClass = DataProviderTM.class)
    public void positiveTest(String subject_name) throws DAOException, SAXException, IOException {

        Subject actual = QuestionsDAOFactory.getInstance().getQuestionsDAO().addSubject(subject_name);

        Assert.assertEquals(actual.getSubject_name(),subject_name);

    }

    @Test(expectedExceptions = { ServiceException.class },dataProvider = "addSubjectNegative", dataProviderClass = DataProviderTM.class)
    public void exceptionTest(String subject_name) throws ServiceException {

        Subject actual = ServiceFactory.getInstance().getTestModuleService().addSubject(subject_name);

        Assert.assertNotEquals(actual.getSubject_name(),subject_name);

    }

}