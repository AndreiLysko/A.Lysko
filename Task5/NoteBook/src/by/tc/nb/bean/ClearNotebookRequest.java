package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;

public class ClearNotebookRequest extends Request {
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
