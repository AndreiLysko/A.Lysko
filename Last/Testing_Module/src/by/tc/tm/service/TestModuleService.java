package by.tc.tm.service;

import by.tc.tm.bean.entity.Question;
import by.tc.tm.bean.entity.Subject;
import by.tc.tm.bean.entity.Test;
import by.tc.tm.service.exception.ServiceException;

import java.util.List;

public interface TestModuleService {

    Subject addSubject(String subject_name) throws ServiceException;

    List<Subject> chooseSubject() throws ServiceException;

    void addQuestion(int subject_ID, String subject_name, String question, int answerNumber, int points) throws ServiceException;

    List<Question> passTest(int subject_id, String subject_name) throws ServiceException;

    Test writeResults(int owner_id, int subject_id, String subject_name, int points) throws ServiceException;

    List<Test> showResults(int user_id) throws ServiceException;

}
