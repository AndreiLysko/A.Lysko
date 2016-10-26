package by.tc.tm.bean.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    private int id_owner;
    private int subject_id;
    private String subject_name;
    private String test_date;
    private int points;

    public Test() {
        this.test_date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }

    public Test(int id_owner, int subject_id, String subject_name, int points) {
        this.id_owner = id_owner;
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.points = points;
        this.test_date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }

    public Test(int id_owner, int subject_id, String subject_name, String test_date, int points) {
        this.id_owner = id_owner;
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.test_date = test_date;
        this.points = points;
    }

    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getTest_date() {
        return test_date;
    }

    public void setTest_date(String test_date) {
        this.test_date = test_date;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Test{" +
                " Subject = '" + subject_name + '\'' +
                ", testing date = '" + test_date + '\'' +
                ", points = " + points + " of 100}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id_owner != test.id_owner) return false;
        if (subject_id != test.subject_id) return false;
        if (points != test.points) return false;
        return test_date.equals(test.test_date);

    }

    @Override
    public int hashCode() {
        int result = id_owner;
        result = 31 * result + subject_id;
        result = 31 * result + test_date.hashCode();
        result = 31 * result + points;
        return result;
    }
}
