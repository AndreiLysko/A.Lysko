package tests;

import by.tc.tm.bean.entity.User;
import by.tc.tm.dao.UserDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.service.ServiceFactory;
import by.tc.tm.service.exception.ServiceException;
import tests.dataProvider.DataProviderTM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class AuthorizeTest {
    @Test(dataProvider = "authorizationPositive", dataProviderClass = DataProviderTM.class)
    public void positiveTest(String login, String password) throws DAOException, SAXException, IOException {

        User actual = UserDAOFactory.getInstance().getUserDAO().authorization(login, password);
        User expected = new User(login);

        Assert.assertEquals(actual.getUsername(),expected.getUsername());

    }


    @Test(dataProvider = "authorizationNegative", dataProviderClass = DataProviderTM.class)
    public void negativeTest(String login, String password) throws DAOException, ServiceException {

        User actual = ServiceFactory.getInstance().getUserService().authorization(login, password);
        Assert.assertNull(actual);

    }

    @Test(expectedExceptions = { ServiceException.class })
    public void exceptionTest() throws ServiceException {

        User actual = ServiceFactory.getInstance().getUserService().authorization(null,null);

        Assert.assertNull(actual);

    }

}