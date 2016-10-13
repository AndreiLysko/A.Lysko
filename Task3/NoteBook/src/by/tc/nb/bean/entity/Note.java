package by.tc.nb.bean.entity;

public class Note {

    private String creationDate;
    private String data;

    public Note() {
    }

    public Note(String data, String creationDate) {
        this.data = data;
        this.creationDate = creationDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override

    public String toString() {
        return (this.creationDate + "  ||  " + this.data);
    }

}
