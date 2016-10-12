package by.tc.nb.bean;

public class FindNoteByDateRequest extends Request {

    private String date;

    public FindNoteByDateRequest() {
    }

    public FindNoteByDateRequest(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
