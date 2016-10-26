package by.tc.nb.service;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Test;
import by.tc.nb.service.exception.ServiceException;

import java.util.List;

public interface TestModuleService {

    void addQuestion(int subject_ID, String question, int answerNumber, int points) throws ServiceException;

    List<Question> passTest(int subject_id) throws ServiceException;

    Test writeResults(int owner_id, int subject_id, int points) throws ServiceException;

}
