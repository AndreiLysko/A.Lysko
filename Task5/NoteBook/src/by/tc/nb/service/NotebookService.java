package by.tc.nb.service;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;
import java.util.ArrayList;

public interface NotebookService {

    void addNote(int userID, String data) throws ServiceException;

    void clearNotebook() throws ServiceException;

    void viewNotes() throws ServiceException;

    ArrayList<Note> findNoteByContent(String searchString) throws ServiceException;

    ArrayList<Note> findNoteByDate(String searchDate) throws ServiceException;

}
