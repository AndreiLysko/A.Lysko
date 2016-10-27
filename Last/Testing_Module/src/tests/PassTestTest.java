package tests;

import by.tc.tm.bean.entity.Question;
import by.tc.tm.dao.QuestionsDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.exception.ServiceException;
import tests.dataProvider.DataProviderTM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class PassTestTest {

    @Test(dataProvider = "passTestPositive", dataProviderClass = DataProviderTM.class)
    public void positiveTest(int subject_id, String subject_name) throws DAOException, SAXException, IOException {

         List<Question> actual = QuestionsDAOFactory.getInstance().getQuestionsDAO().passTest(subject_id, subject_name);

        Assert.assertFalse(actual.isEmpty());

    }

    @Test(dataProvider = "passTestNegative", dataProviderClass = DataProviderTM.class, expectedExceptions = { ServiceException.class })
    public void exceptionTest(int subject_id, String subject_name) throws DAOException, SAXException, IOException, ServiceException {

        List<Question> actual = ServiceFactory.getInstance().getTestModuleService().passTest(subject_id, subject_name);

        Assert.assertFalse(actual.isEmpty());
    }

}