package by.tc.nb.dao.impl.mysql;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Subjects;
import by.tc.nb.bean.entity.Test;
import by.tc.nb.dao.QuestionsDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.impl.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLQuestionsDAO implements QuestionsDAO {

	@Override
	public void addQuestion(int subject_id, Question question) throws DAOException {
		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			try(Statement statement = connection.createStatement()) {
				statement.executeUpdate("INSERT INTO questions(id_subject, name_subject, question_text, answer_number, points) VALUES("
						+ subject_id + ",'" + question.getName_subject() + "','"
						+ question.getText() + "','" +question.getAnswer() +"','"
                        + question.getPoints() +"');");
			}
		} catch (InterruptedException | SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				ConnectionPool.getInstance().returnConnection(connection);
			} catch (SQLException | InterruptedException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	@Override
	public List<Question> passTest(int subject_id) throws DAOException {
		Connection connection = null;
		List<Question> questions = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			Statement statement = connection.createStatement();
			result = statement.executeQuery("SELECT question_text, answer_number, points FROM questions WHERE id_subject="
			+ subject_id + ";");
			while (result.next()){
				questions.add(new Question(subject_id, Subjects.values()[subject_id].toString(),
						result.getString(1),result.getInt(2),result.getInt(3)));
			}
		}
		catch (InterruptedException | SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				ConnectionPool.getInstance().returnConnection(connection);
			}
			catch (SQLException | InterruptedException e){
				throw new DAOException(e.getMessage());
			}
		}
		return questions;
	}

	@Override
	public Test writeResults(int owner_id, int subject_id, int points) throws DAOException {

		Connection connection = null;
		Test test = new Test();

		try {
			connection = ConnectionPool.getInstance().getConnection();
			Statement statement = connection.createStatement();
			statement.executeQuery("INSERT INTO results(id_owner, subject_id, subject_name, test_date, points) VALUES("
					+ owner_id + ",'" + subject_id + "','"
					+ Subjects.values()[subject_id] + "','" +test.getTest_date() +"','"
					+ points +"');");
			test.setId_owner(owner_id);
			test.setSubject_id(subject_id);
			test.setPoints(points);
			test.setSubject_name(Subjects.values()[subject_id].toString());
		}
		catch (InterruptedException | SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				ConnectionPool.getInstance().returnConnection(connection);
			}
			catch (SQLException | InterruptedException e){
				throw new DAOException(e.getMessage());
			}
		}
		return test;
	}
}
