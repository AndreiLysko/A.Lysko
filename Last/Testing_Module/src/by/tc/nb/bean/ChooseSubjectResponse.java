package by.tc.nb.bean;

import by.tc.nb.bean.entity.Subject;

import java.util.List;

public class ChooseSubjectResponse extends Response {

    List<Subject> subjects;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
