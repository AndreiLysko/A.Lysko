package by.tc.tm.bean.entity;

import java.io.Serializable;

public class Question implements Serializable   {

    private int id_subject;
    private String name_subject;
    private String text;
    private int answer;
    private int points;

    public Question() {
    }

    public Question(String text) {
        this.text = text;
    }

    public Question(String text, int answer, int points) {
        this.text = text;
        this.answer = answer;
        this.points = points;
    }

    public Question(int id_subject, String name_subject, String text, int answer, int points) {
        this.id_subject = id_subject;
        this.name_subject = name_subject;
        this.text = text;
        this.answer = answer;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    @Override
    public String toString() {
        return "Question{" +
                "name_subject='" + name_subject + '\'' +
                ", text='" + text + '\'' +
                ", answer=" + answer +
                ", points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id_subject != question.id_subject) return false;
        if (answer != question.answer) return false;
        if (points != question.points) return false;
        return text.equals(question.text);

    }

    @Override
    public int hashCode() {
        int result = id_subject;
        result = 31 * result + text.hashCode();
        result = 31 * result + answer;
        result = 31 * result + points;
        return result;
    }
}
