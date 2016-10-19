package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.NoteBookDAOFactory;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.utils.check.Validate;

import java.util.List;

public class NotebookServiceImpl implements NotebookService{


    @Override
    public void addNote(int userID, String note) throws ServiceException {

        if(!Validate.note(userID, note)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            NoteBookDAOFactory.getInstance().getNoteBookDAO().addNote(userID,new Note(note));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void clearNotebook(int userID) throws ServiceException {

        if(userID < 0) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            NoteBookDAOFactory.getInstance().getNoteBookDAO().clearNotebook(userID);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Note> findNoteByContent(int userID, String content) throws ServiceException {

        if(!Validate.note(userID, content)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return NoteBookDAOFactory.getInstance().getNoteBookDAO().findNoteByContent(userID, content);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Note> findNoteByDate(int userID, String date) throws ServiceException {

        if(!Validate.note(userID, date)) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return NoteBookDAOFactory.getInstance().getNoteBookDAO().findNoteByDate(userID, date);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Note> viewNotes(int userID) throws ServiceException {

        if(userID < 0) {
            throw new ServiceException("Incorrect parameters");
        }

        try {
            return NoteBookDAOFactory.getInstance().getNoteBookDAO().viewNotes(userID);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
