package by.tc.tm.bean.entity;

public class Subject {

    private String subject_name;
    private int subjectID;

    public Subject() {
    }

    public Subject(String subject_name) {
        this.subject_name = subject_name;
    }

    public Subject(int subjectID, String subject_name) {
        this.subject_name = subject_name;
        this.subjectID = subjectID;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (subjectID != subject.subjectID) return false;
        return subject_name.equals(subject.subject_name);

    }

    @Override
    public int hashCode() {
        int result = subject_name.hashCode();
        result = 31 * result + subjectID;
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_name='" + subject_name + '\'' +
                ", subjectID=" + subjectID +
                '}';
    }
}
