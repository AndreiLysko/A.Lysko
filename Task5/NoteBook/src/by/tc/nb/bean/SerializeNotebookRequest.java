package by.tc.nb.bean;

public class SerializeNotebookRequest extends Request{

    String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public SerializeNotebookRequest() {
    }

    public SerializeNotebookRequest(String filePath) {
        this.filePath = filePath;
    }
}
