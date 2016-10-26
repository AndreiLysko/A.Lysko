package by.tc.nb.dao.impl.mysql;

import by.tc.nb.bean.entity.Question;
import by.tc.nb.bean.entity.Subject;
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
	public Subject addSubject(String subject_name) throws DAOException {

		Connection connection = null;
		ResultSet result;
		Subject subject = new Subject();

		try {
			connection = ConnectionPool.getInstance().getConnection();
			Statement statement = connection.createStatement();

			result = statement.executeQuery("SELECT * FROM subjects WHERE subject_name='"
					+ subject_name + "';");

			if (!result.next()){

				statement.executeUpdate("INSERT INTO subjects(subject_name) VALUES('"
						+ subject_name + "');");

				result = statement.executeQuery("SELECT subject_id FROM subjects WHERE subject_name='"
				+ subject_name + "';");

				while (result.next()) {
					subject = new Subject(result.getInt(1), subject_name);
				}
			}
		}
		catch (InterruptedException | SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				ConnectionPool.getInstance().returnConnection(connection);
			} catch (SQLException | InterruptedException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return subject;
	}

	@Override
	public List<Subject> chooseSubject() throws DAOException {

		Connection connection = null;
		List<Subject> subjects = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			Statement statement = connection.createStatement();

			result = statement.executeQuery("SELECT * FROM subjects;");
			while (result.next()){
				subjects.add(new Subject(result.getInt(1),result.getString(2)));
			}
		}
		catch (InterruptedException | SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				ConnectionPool.getInstance().returnConnection(connection);
			} catch (SQLException | InterruptedException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return subjects;
	}

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
	public List<Question> passTest(int subject_id, String subject_name) throws DAOException {
		Connection connection = null;
		List<Question> questions = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			Statement statement = connection.createStatement();

			result = statement.executeQuery("SELECT question_text, answer_number, points FROM questions WHERE id_subject="
			+ subject_id + ";");

			while (result.next()){
				questions.add(new Question(subject_id, subject_name,
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
	public Test writeResults(int owner_id, int subject_id, String subject_name, int points) throws DAOException {

		Connection connection = null;
		Test test = new Test();

		try {
			connection = ConnectionPool.getInstance().getConnection();
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO results(id_owner, subject_id, subject_name, test_date, points) VALUES('"
					+ owner_id + "','" + subject_id + "','"
					+ subject_name + "','" + test.getTest_date() +"','"
					+ points +"');");

			test.setId_owner(owner_id);
			test.setSubject_id(subject_id);
			test.setPoints(points);
			test.setSubject_name(subject_name);
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

	@Override
	public List<Test> showResults(int user_id) throws DAOException {
		return null;
	}
}
