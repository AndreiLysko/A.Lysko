package by.tc.nb.dao;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Test;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.exception.ServiceException;

import java.util.List;

public interface QuestionsDAO {
	
	void addQuestion(int userID, Question question) throws DAOException;

	List<Question> passTest(int subject_id) throws DAOException;

	Test writeResults(int owner_id, int subject_id, int points) throws DAOException;

}
