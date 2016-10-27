package by.tc.tm.tests;

import by.tc.tm.dao.QuestionsDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.service.exception.ServiceException;
import by.tc.tm.tests.dataProvider.DataProviderTM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import java.io.IOException;


public class WriteResultsTest {

    // Лучше этого вообще не делать :)
    @Test(dataProvider = "writeResultsPositive", dataProviderClass = DataProviderTM.class)
    public void positiveTest(int owner_id, int subject_id, String subject_name, int points) throws DAOException, SAXException, IOException, ServiceException {

        by.tc.tm.bean.entity.Test actual = QuestionsDAOFactory.getInstance().getQuestionsDAO().writeResults(owner_id, subject_id, subject_name, points);

        Assert.assertTrue(actual.equals(new by.tc.tm.bean.entity.Test(owner_id,subject_id,subject_name,points)));

    }


    @Test(dataProvider = "writeResultsNegative", dataProviderClass = DataProviderTM.class, expectedExceptions = { ServiceException.class })
    public void exceptionTest(int owner_id, int subject_id, String subject_name, int points) throws DAOException, SAXException, IOException, ServiceException {

        by.tc.tm.bean.entity.Test actual = QuestionsDAOFactory.getInstance().getQuestionsDAO().writeResults(owner_id, subject_id, subject_name, points);

        Assert.assertFalse(actual.getId_owner() == owner_id);
    }
}