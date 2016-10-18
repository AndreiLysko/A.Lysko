package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.service.NotebookService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.utils.check.Validate;

import java.io.*;
import java.util.ArrayList;

public class NotebookServiceImpl implements NotebookService{

    @Override
    public void addNote(String data, String creationDate) throws ServiceException {

        if (data == null || creationDate == null || creationDate.isEmpty() || Validate.isDate(creationDate)){
            throw new ServiceException("Incorrect parameters");
        }

        Note note = new Note(data,creationDate);

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
    public ArrayList<Note> loadNotebookFromFile(String filePath) throws ServiceException, IOException {

        NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
        if(filePath.isEmpty()){
            throw new ServiceException("WIncorrect parameter");
        }
        else{
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String buffer;
            String date = null;
            String content = null;

            while ((buffer = br.readLine()) != null) {
                if (Validate.note(buffer)) {
                    int i = 0;
                    for (String noteText : buffer.split("  \\|\\|  ",2)) {
                        if (i == 0) {
                            date = noteText;
                            i++;
                        }
                        else{
                            content = noteText;
                        }
                    }
                    Note note = new Note(content, date);
                    notebook.getNotes().add(note);
                }
                else {
                    System.out.println("Incorrect note format " + buffer);
                }
            }
            br.close();
        }
        return notebook.getNotes();
    }

    @Override
    public void writeNotebookToFile(String filePath) throws ServiceException, IOException {

        NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
        if(filePath.isEmpty()){
            throw new ServiceException("Incorrect parameter!");
        }else {
            FileWriter writer = new FileWriter(filePath);
            for (Note note : notebook.getNotes()){
                writer.write(note.toString());
                writer.append("\n");
            }
            writer.close();
        }
    }

    @Override
    public void serializeNotebook(String filepath) throws ServiceException {
        NoteBook notebook = NoteBookProvider.getInstance().getNoteBook();
        if (notebook.getNotes().isEmpty()){
            throw new ServiceException("Notebook is empty");
        }
        else {
            try {
                FileOutputStream fos = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(notebook);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                throw new ServiceException("Writing to file failed " + e.getMessage());
            } catch (IOException e) {
                throw new ServiceException("Writing to file failed " + e.getMessage());
            }
        }
    }

    @Override
    public ArrayList<Note> deserializeNotebook(String filepath) throws ServiceException {
        NoteBook notebook;
        if (!(new File(filepath).exists())) {
            throw new ServiceException("Incorrect filepath");
        }
        else {
            try {
                FileInputStream in = new FileInputStream(filepath);
                ObjectInputStream oin = new ObjectInputStream(in);
                notebook = (NoteBook) oin.readObject();
                in.close();
            } catch (IOException e) {
                throw new ServiceException("Loading from file failed " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new ServiceException("Error occured " + e.getMessage());
            }
        }
        NoteBookProvider.getInstance().setNoteBook(notebook);
        return notebook.getNotes();
    }
}
