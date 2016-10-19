package by.tc.nb.bean.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note implements Serializable   {

    private String creationDate;
    private String data;

    public Note() {
    }

    public Note(String data) {
        this.data = data;
        this.creationDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
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
        return (creationDate + "  ||  " + data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (creationDate != null ? !creationDate.equals(note.creationDate) : note.creationDate != null) return false;
        return data != null ? data.equals(note.data) : note.data == null;

    }

    @Override
    public int hashCode() {
        int result = creationDate != null ? creationDate.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
