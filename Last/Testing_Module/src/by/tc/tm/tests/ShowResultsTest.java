package by.tc.tm.tests;

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

public class ShowResultsTest {

    @Test(dataProvider = "showResultsPositive", dataProviderClass = DataProviderTM.class)
    public void positiveTest(int owner_id, int subject_id, String subject_name, int points) throws DAOException, SAXException, IOException {

        QuestionsDAOFactory.getInstance().getQuestionsDAO().writeResults(owner_id,subject_id,subject_name,points);

        List<by.tc.tm.bean.entity.Test> actual = QuestionsDAOFactory.getInstance().getQuestionsDAO().showResults(owner_id);

        Assert.assertFalse(actual.isEmpty());

    }

    @Test(dataProvider = "showResultsNegative", dataProviderClass = DataProviderTM.class, expectedExceptions = { ServiceException.class })
    public void exceptionTest(int owner_id) throws DAOException, SAXException, IOException, ServiceException {

        List<by.tc.tm.bean.entity.Test> actual = ServiceFactory.getInstance().getTestModuleService().showResults(owner_id);

        Assert.assertFalse(actual.isEmpty());
    }

}