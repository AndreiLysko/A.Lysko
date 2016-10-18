package by.tc.nb.source;

public class NoteBookProvider {
    private static final NoteBookProvider instance = new NoteBookProvider();

    private NoteBook noteBook;

    private NoteBookProvider() {
        noteBook = new NoteBook();
    }


    public static NoteBookProvider getInstance() {
        return instance;
    }


    public NoteBook getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(NoteBook noteBook) {
        this.noteBook = noteBook;
    }
}
