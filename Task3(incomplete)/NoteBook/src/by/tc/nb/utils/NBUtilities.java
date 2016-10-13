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

    public static ArrayList<Note> findNotesByContent(String searchData, NoteBook notebook) {

        ArrayList<Note> notes = new ArrayList<>();
        notebook.getNotes().stream().forEach(note -> {
            if (Validate.content(searchData, note)) {
                notes.add(note);
            }
        });
        return notes;
    }

    public static ArrayList<Note> findNotesByDate(String searchDate, NoteBook notebook) {

        ArrayList<Note> notes = new ArrayList<>();
        if (!notebook.getNotes().isEmpty()) {
            notebook.getNotes().stream().forEach(note -> {
                if (Validate.date(searchDate, note)) {
                    notes.add(note);
                }
            });
        }
        else {
            System.out.println("No notes found");
        }
        return notes;
    }

    public static ArrayList<Note> loadNotesFromFile(String filePath, NoteBook notebook) throws IOException {

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
                addNote(notebook, note);
            }
            else {
                System.out.println("Incorrect note format " + buffer);
            }
        }
        br.close();
        return notebook.getNotes();
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
