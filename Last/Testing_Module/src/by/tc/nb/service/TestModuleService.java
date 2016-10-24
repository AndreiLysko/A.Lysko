package by.tc.nb.service;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.service.exception.ServiceException;

import java.util.List;

public interface TestModuleService {

    void addQuestion(int userID, String question, int subjectID) throws ServiceException;
    void clearNotebook(int userID) throws ServiceException;

    List<Question> findNoteByContent(int userID, String content) throws ServiceException;
    List<Question> findNoteByDate(int userID, String date) throws ServiceException;
    List<Question> viewNotes(int userID) throws ServiceException;

}
