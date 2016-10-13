package by.tc.nb.bean;

public class WriteNotebookToFileRequest extends Request {

    private String filePath;

    public WriteNotebookToFileRequest() {
    }

    public WriteNotebookToFileRequest(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
