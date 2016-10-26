package by.tc.tm.bean;

import by.tc.tm.bean.entity.Test;

public class WriteResultsResponse extends Response {

    Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
