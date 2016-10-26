package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Subjects;
import by.tc.nb.bean.entity.Test;
import by.tc.nb.dao.QuestionsDAOFactory;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.TestModuleService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.utils.check.Validate;

import java.util.List;

public class TestModuleServiceImpl implements TestModuleService {


    @Override
    public void addQuestion(int subject_ID, String question, int answerNumber, int points) throws ServiceException {

        if(!Validate.question(subject_ID, question)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            QuestionsDAOFactory.getInstance().getQuestionsDAO().addQuestion(subject_ID,new Question(subject_ID, Subjects.values()[subject_ID].toString(),question,answerNumber,points));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Question> passTest(int subject_id) throws ServiceException {
        if (subject_id < 0){
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().passTest(subject_id);
        }
        catch (DAOException e) {
            throw new ServiceException("Incorrect parameters");
        }
    }

    @Override
    public Test writeResults(int owner_id, int subject_id, int points) throws ServiceException {
        if (subject_id < 0 || owner_id < 0){
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().writeResults(owner_id, subject_id, points);
        }
        catch (DAOException e) {
            throw new ServiceException("Incorrect parameters");
        }
    }

    /*    @Override
    public List<Question> viewNotes(int userID) throws ServiceException {

        if(userID < 0) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().viewNotes(userID);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    } */
}
