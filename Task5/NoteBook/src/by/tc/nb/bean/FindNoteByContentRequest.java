package by.tc.nb.bean;

public class FindNoteByContentRequest extends Request {

    private String content;
    private int userID;

    public FindNoteByContentRequest() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
