package by.tc.nb.service;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface NotebookService {

    void addNote(int userID, String note);
    void clearNotebook(int userID);

    List<Note> findNoteByContent(int userID, String content);
    List<Note> findNoteByDate(int userID, String date);
    List<Note> viewNotes(int userID);

}
