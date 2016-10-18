package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class ViewNotesResponse extends Response {

    private List<Note> notes = null;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
