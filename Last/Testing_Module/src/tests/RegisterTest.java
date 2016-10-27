package tests;

import by.tc.tm.dao.UserDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.exception.ServiceException;
import tests.dataProvider.DataProviderTM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class RegisterTest {

    @Test(dataProvider = "registrationPositive", dataProviderClass = DataProviderTM.class)
    public void positiveTest(String login, String password) throws DAOException, SAXException, IOException {

        boolean actual = UserDAOFactory.getInstance().getUserDAO().registration(login, password);

        Assert.assertTrue(actual);

    }


    @Test(expectedExceptions = {ServiceException.class} ,dataProvider = "registrationNegative", dataProviderClass = DataProviderTM.class)
    public void negativeTest(String login, String password) throws ServiceException {

        boolean actual = ServiceFactory.getInstance().getUserService().registration(login, password);

        Assert.assertFalse(actual);

    }

}