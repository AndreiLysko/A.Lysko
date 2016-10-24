package by.tc.nb.dao;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.dao.exception.DAOException;

import java.util.List;

public interface QuestionsDAO {
	
	void addQuestion(int userID, Question question) throws DAOException;
	void clearNotebook(int userID) throws DAOException;

	List<Question> findNoteByContent(int userID, String content) throws DAOException;
	List<Question> findNoteByDate(int userID, String date) throws DAOException;
	List<Question> viewNotes(int userID) throws DAOException;

}
