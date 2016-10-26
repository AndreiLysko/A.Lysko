package by.tc.nb.bean;

import by.tc.nb.bean.entity.Test;

import java.util.List;

public class ShowResultsResponse extends Response {

    List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
