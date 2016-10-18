package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.check.Validate;

import java.io.*;
import java.util.ArrayList;

public class NotebookServiceImpl implements NotebookService{

    @Override
    public void addNote(int userID, String data) throws ServiceException {

        if (data == null){
            throw new ServiceException("Incorrect parameters");
        }

        Note note = new Note(data);

        NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
        notebook.getNotes().add(note);
    }

    @Override
    public void clearNotebook() throws ServiceException {

        NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
        notebook.getNotes().clear();

    }

    @Override
    public void viewNotes() throws ServiceException {

        NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
        if (!notebook.getNotes().isEmpty()){
            System.out.println("Notebook contains :");
            notebook.getNotes().stream().forEach(note -> System.out.println(note));
        }

    }

    @Override
    public ArrayList<Note> findNoteByContent(String searchData) throws ServiceException {

        ArrayList<Note> notes = new ArrayList<>();

        if (searchData.isEmpty()){
            throw new ServiceException("Incorrect parameters");
        }
        else {
            NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
            notebook.getNotes().stream().forEach(note -> {
                if (Validate.content(searchData, note)) {
                    notes.add(note);
                }
            });
        }
        return notes;
    }

    @Override
    public ArrayList<Note> findNoteByDate(String searchDate) throws ServiceException {

        ArrayList<Note> notes = new ArrayList<>();

        if (searchDate.isEmpty()){
            throw new ServiceException("Incorrect parameters");
        }
        else {

            NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
            if (!notebook.getNotes().isEmpty()) {
                notebook.getNotes().stream().forEach(note -> {
                    if (Validate.date(searchDate, note)) {
                        notes.add(note);
                    }
                });
            }
        }
        return notes;
    }


    @Override
    public int login(String username, String password) throws ServiceException {
        return 0;
    }

    @Override
    public boolean registration(String username, String password) throws ServiceException {
        return false;
    }
}
