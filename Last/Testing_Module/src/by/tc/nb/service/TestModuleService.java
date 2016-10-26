package by.tc.nb.service;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Subject;
import by.tc.nb.bean.entity.Test;
import by.tc.nb.service.exception.ServiceException;

import java.util.List;

public interface TestModuleService {

    Subject addSubject(String subject_name) throws ServiceException;

    List<Subject> chooseSubject() throws ServiceException;

    void addQuestion(int subject_ID, String subject_name, String question, int answerNumber, int points) throws ServiceException;

    List<Question> passTest(int subject_id, String subject_name) throws ServiceException;

    Test writeResults(int owner_id, int subject_id, String subject_name, int points) throws ServiceException;

}
