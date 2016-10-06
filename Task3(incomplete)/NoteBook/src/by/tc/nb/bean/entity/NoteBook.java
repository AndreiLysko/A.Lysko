package by.tc.nb.bean.entity;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {

	List<Note> notes = null;

	public NoteBook() {
		notes = new ArrayList<>();
	}

	public NoteBook(List<Note> notes) {
		this.notes = notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Note> getNotes() {
		return new ArrayList<>(notes);
	}



}
