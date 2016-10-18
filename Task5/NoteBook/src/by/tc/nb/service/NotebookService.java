package by.tc.nb.service;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;
import java.util.ArrayList;

public interface NotebookService {

    void addNote(String data, String creationDate) throws ServiceException;

    void clearNotebook() throws ServiceException;

    void viewNotes() throws ServiceException;

    ArrayList<Note> findNoteByContent(String searchString) throws ServiceException;

    ArrayList<Note> findNoteByDate(String searchDate) throws ServiceException;

    ArrayList<Note> loadNotebookFromFile(String filePath) throws ServiceException, IOException;

    void writeNotebookToFile(String filePath) throws ServiceException, IOException;

    void serializeNotebook(String filePath) throws ServiceException;

    ArrayList<Note> deserializeNotebook(String filePath) throws ServiceException;

    int login(String username, String password) throws ServiceException;

    boolean registration (String username, String password) throws ServiceException;
}
