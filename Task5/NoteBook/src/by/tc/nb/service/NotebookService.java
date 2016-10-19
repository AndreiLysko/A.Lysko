package by.tc.nb.service;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface NotebookService {

    void addNote(int userID, String note) throws ServiceException;
    void clearNotebook(int userID) throws ServiceException;

    List<Note> findNoteByContent(int userID, String content) throws ServiceException;
    List<Note> findNoteByDate(int userID, String date) throws ServiceException;
    List<Note> viewNotes(int userID) throws ServiceException;

}
