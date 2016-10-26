package by.tc.tm.bean;

import by.tc.tm.bean.entity.Subject;

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
