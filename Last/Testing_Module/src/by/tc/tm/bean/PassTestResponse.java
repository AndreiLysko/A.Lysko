package by.tc.tm.bean;

import by.tc.tm.bean.entity.Question;

import java.util.List;

public class PassTestResponse extends Response {

    List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
