package by.tc.nb.dao;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Subject;
import by.tc.nb.bean.entity.Test;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.exception.ServiceException;

import java.util.List;

public interface QuestionsDAO {

    Subject addSubject(String subject_name) throws DAOException;

    List<Subject> chooseSubject() throws DAOException;
	
	void addQuestion(int userID, Question question) throws DAOException;

	List<Question> passTest(int subject_id, String subject_name) throws DAOException;

	Test writeResults(int owner_id, int subject_id, String subject_name, int points) throws DAOException;

    List<Test> showResults(int user_id) throws DAOException;

}
