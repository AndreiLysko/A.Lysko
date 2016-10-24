package by.tc.nb.bean;

import by.tc.nb.bean.entity.Question;

import java.util.List;

public class FindNoteByDateResponse extends Response {

    List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
