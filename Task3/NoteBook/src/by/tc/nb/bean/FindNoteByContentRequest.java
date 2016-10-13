package by.tc.nb.bean;

public class FindNoteByContentRequest extends Request {

    private String content;

    public FindNoteByContentRequest() {
    }

    public FindNoteByContentRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
