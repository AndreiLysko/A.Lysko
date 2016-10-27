package by.tc.tm.tests;

import by.tc.tm.bean.entity.User;
import by.tc.tm.dao.UserDAOFactory;
import by.tc.tm.dao.exception.DAOException;
import by.tc.tm.tests.dataProvider.DataProviderTM;
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
    public void negativeTest(String login, String password) throws DAOException {

        User actual = UserDAOFactory.getInstance().getUserDAO().authorization(login, password);
        User expected = new User(login);
        Assert.assertNotEquals(actual.getUsername(),expected.getUsername());

    }

    @Test(expectedExceptions = { DAOException.class })
    public void exceptionTest() throws DAOException {

        User actual = UserDAOFactory.getInstance().getUserDAO().authorization(null, null);
        User expected = new User();

        Assert.assertNotEquals(actual.getUsername(),expected.getUsername());

    }

}