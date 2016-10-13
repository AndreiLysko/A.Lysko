package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;

public class FindNoteByDateResponse extends Response {

    List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
