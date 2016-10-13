package by.tc.nb.bean;

public class LoadNotebookFromFileRequest extends Request {

    private String filePath;

    public LoadNotebookFromFileRequest() {
    }

    public LoadNotebookFromFileRequest(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
