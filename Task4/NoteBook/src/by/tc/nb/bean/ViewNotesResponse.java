package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.ArrayList;

public class ViewNotesResponse extends Response {

    private ArrayList<Note> notes = null;

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
}
