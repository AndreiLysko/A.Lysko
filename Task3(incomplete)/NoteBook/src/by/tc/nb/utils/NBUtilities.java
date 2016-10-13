package by.tc.nb.utils;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.utils.check.Validate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NBUtilities {

    public static void addNote(NoteBook nb, Note note) {
        nb.getNotes().add(note);
    }

    public static ArrayList<Note> findNotesByContent(String searchData, NoteBook noteBook) {

        ArrayList<Note> notes = new ArrayList<>();
        for (Note note : noteBook.getNotes()) {
            if (Validate.content(searchData, note)) {
                notes.add(note);
            }
        }
        return notes;
    }

    public static ArrayList<Note> findNotesByDate(String searchDate, NoteBook noteBook) {

        ArrayList<Note> notes = new ArrayList<>();
        if (!noteBook.getNotes().isEmpty()) {
            for (Note note : noteBook.getNotes()) {
                if (Validate.date(searchDate, note)) {
                    notes.add(note);
                }
            }
        }
        else {
            System.out.println("No notes found");
        }
        return notes;
    }

    public static ArrayList<Note> loadNotesFromFile(String filePath, NoteBook noteBook) throws IOException {

        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String buffer;
        String date;
        String content;
        String[] text = new String[2];

        while (!(br.readLine() == null)) {
            buffer = br.readLine();
            if (Validate.note(buffer)) {
                int i = 0;
                for (String noteText : buffer.split("  ||  ", 2)) {
                    text[i] = noteText;
                }
                date = text[0];
                content = text[1];
                Note note = new Note(date, content);
                addNote(noteBook, note);
            }
            else {
                System.out.println("Incorrect note format" + buffer);
            }
        }
        br.close();
        return noteBook.getNotes();
    }

    public static void writeNotesToFile(String filePath, NoteBook notebook) throws IOException{
        FileWriter writer = new FileWriter(filePath);
        for (Note note : notebook.getNotes()){
            writer.write(note.toString());
            writer.append("\n");
        }
        writer.close();
    }




}
