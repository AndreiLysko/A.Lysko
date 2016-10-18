package by.tc.nb.dao;

import by.tc.nb.dao.impl.mysql.MySQLNoteBookDAO;

public class NoteBookDAOFactory {

    private static final NoteBookDAOFactory instance = new NoteBookDAOFactory();
    private NoteBookDAO noteBookDAO = new MySQLNoteBookDAO();

    public static NoteBookDAOFactory getInstance() {
        return instance;
    }

    public NoteBookDAO getNoteBookDAO() {
        return noteBookDAO;
    }
}
