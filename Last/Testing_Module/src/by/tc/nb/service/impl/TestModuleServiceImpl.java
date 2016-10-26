package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Subject;
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
    public void addQuestion(int subject_ID, String subject_name, String question, int answerNumber, int points) throws ServiceException {

        if(!Validate.question(subject_ID, question)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            QuestionsDAOFactory.getInstance().getQuestionsDAO().addQuestion(subject_ID,new Question(subject_ID, subject_name,question,answerNumber,points));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Question> passTest(int subject_id, String subject_name) throws ServiceException {
        if (subject_id < 0 || subject_name.equals("")){
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().passTest(subject_id, subject_name);
        }
        catch (DAOException e) {
            throw new ServiceException("Incorrect parameters");
        }
    }

    @Override
    public Test writeResults(int owner_id, int subject_id, String subject_name, int points) throws ServiceException {

        if (subject_id < 0 || owner_id < 0){
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().writeResults(owner_id, subject_id, subject_name, points);
        }
        catch (DAOException e) {
            throw new ServiceException("Incorrect parameters");
        }
    }

    @Override
    public Subject addSubject(String subject_name) throws ServiceException {

        if(subject_name.equals("")){
            throw new ServiceException("Incorrect parameters");
        }
        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().addSubject(subject_name);
        }
        catch (DAOException e){
            throw new ServiceException("Incorrect parameters");
        }
    }

    @Override
    public List<Subject> chooseSubject() throws ServiceException {

        try {
            return QuestionsDAOFactory.getInstance().getQuestionsDAO().chooseSubject();
        }
        catch (DAOException e){
            throw new ServiceException("Incorrect parameters");
        }
    }
}
