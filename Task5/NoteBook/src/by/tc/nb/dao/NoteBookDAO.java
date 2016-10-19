package by.tc.nb.dao;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.exception.DAOException;

import java.util.List;

public interface NoteBookDAO {
	
	void addNote(int userID, Note note) throws DAOException;
	void clearNotebook(int userID) throws DAOException;

	List<Note> findNoteByContent(int userID, String content) throws DAOException;
	List<Note> findNoteByDate(int userID, String date) throws DAOException;
	List<Note> viewNotes(int userID) throws DAOException;

}
