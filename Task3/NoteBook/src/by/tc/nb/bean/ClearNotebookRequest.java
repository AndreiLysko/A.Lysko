package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;

public class ClearNotebookRequest extends Request {
    private List<Note> findBook;

    public List<Note> getFindBook() {
        return findBook;
    }

    public void setFindBook(List<Note> findBook) {
        this.findBook = findBook;
    }


}
