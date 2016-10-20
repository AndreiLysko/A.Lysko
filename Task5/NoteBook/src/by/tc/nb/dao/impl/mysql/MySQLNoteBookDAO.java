package by.tc.nb.dao.impl.mysql;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.NoteBookDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.impl.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLNoteBookDAO implements NoteBookDAO{

	@Override
	public void addNote(int userID, Note note) throws DAOException {
		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			try(Statement statement = connection.createStatement()) {
				statement.executeUpdate("INSERT INTO notes(id_owner, message, date) VALUES("
						+ userID + ",'" + note.getData() + "','" + note.getCreationDate() + "');");
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
	public List<Note> findNoteByContent(int userID, String content) throws DAOException{
		Connection connection = null;
		Statement statement;
		List<Note> notes = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT date, message FROM notes WHERE id_owner="
					+ userID + " AND message LIKE '%" + content + "%';");
			while (result.next()){
				notes.add(new Note(result.getString(1),result.getString(2)));
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
		return notes;
	}

	@Override
	public List<Note> findNoteByDate(int userID, String date) throws DAOException {
		Connection connection = null;
		Statement statement = null;
		List<Note> notes = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT date, message FROM notes WHERE id_owner="
					+ userID + " AND date='" + date + "';");
			while (result.next()){
				notes.add(new Note(result.getString(1),result.getString(2)));
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
		return notes;
	}

	@Override
	public List<Note> viewNotes(int userID) throws DAOException {
		Connection connection = null;
		Statement statement;
		List<Note> notes = new ArrayList<>();
		ResultSet result;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT date, message FROM notes WHERE id_owner='" + userID + "';");
			while (result.next()){
				notes.add(new Note(result.getString(1),result.getString(2)));
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
		return notes;
	}
}
