package by.tc.nb.bean;

public class DeserializeNotebookRequest extends Request{

    String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public DeserializeNotebookRequest() {
    }

    public DeserializeNotebookRequest(String filePath) {
        this.filePath = filePath;
    }
}
