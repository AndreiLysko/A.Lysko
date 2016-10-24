package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.dao.QuestionsDAOFactory;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.utils.check.Validate;

import java.util.List;

public class TestModuleServiceImpl implements TestModuleService {


    @Override
    public void addQuestion(int userID, String question, int questionID) throws ServiceException {

        if(!Validate.question(userID, question)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            QuestionsDAOFactory.getInstance().getQuestionsDAO().addQuestion(userID,new Question(question));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void clearNotebook(int userID) throws ServiceException {

        if(userID < 0) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            QuestionsDAOFactory.getInstance().getQuestionsDAO().clearNotebook(userID);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Question> findNoteByContent(int userID, String content) throws ServiceException {

        if(!Validate.question(userID, content)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().findNoteByContent(userID, content);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Question> findNoteByDate(int userID, String date) throws ServiceException {

        if(!Validate.question(userID, date)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().findNoteByDate(userID, date);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Question> viewNotes(int userID) throws ServiceException {

        if(userID < 0) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().viewNotes(userID);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
