package by.tc.nb.dao.impl.mysql;

import by.tc.nb.bean.entity.Question;
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
				statement.executeUpdate("INSERT INTO questions(id_subject, name_subjects, question_text, answer_number, points) VALUES("
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
	public void clearNotebook(int userID) throws DAOException {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement.executeUpdate("DELETE FROM notes WHERE id_owner=" + userID + ";");
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
	public List<Question> findNoteByContent(int userID, String content) throws DAOException{
		Connection connection = null;
		Statement statement;
		List<Question> questions = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT date, message FROM notes WHERE id_owner="
					+ userID + " AND message LIKE '%" + content + "%';");
			while (result.next()){
				//questions.add(new Question(result.getString(1),result.getString(2)));
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
		return questions;
	}

	@Override
	public List<Question> findNoteByDate(int userID, String date) throws DAOException {
		Connection connection = null;
		Statement statement = null;
		List<Question> questions = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT date, message FROM notes WHERE id_owner="
					+ userID + " AND date='" + date + "';");
			while (result.next()){
				//questions.add(new Question(result.getString(1),result.getString(2)));
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
		return questions;
	}

	@Override
	public List<Question> viewNotes(int userID) throws DAOException {
		Connection connection = null;
		Statement statement;
		List<Question> questions = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT date, message FROM notes WHERE id_owner='" + userID + "';");
			while (result.next()){
				//questions.add(new Question(result.getString(1),result.getString(2)));
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
		return questions;
	}
}
