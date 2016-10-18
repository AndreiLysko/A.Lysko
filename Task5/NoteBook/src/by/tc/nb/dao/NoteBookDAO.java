package by.tc.nb.dao;

import by.tc.nb.bean.entity.Note;

import java.util.List;

public interface NoteBookDAO {
	
	void addNote(int userID, String note);
	void clearNotebook(int userID);

	List<Note> findNoteByContent(int userID, String content);
	List<Note> findNoteByDate(int userID, String date);
	List<Note> viewNotes(int userID);

}
