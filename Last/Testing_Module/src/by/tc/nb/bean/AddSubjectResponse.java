package by.tc.nb.bean;

import by.tc.nb.bean.entity.Subject;

public class AddSubjectResponse extends Response {

    Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
