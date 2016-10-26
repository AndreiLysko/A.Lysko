package by.tc.nb.bean;

import by.tc.nb.bean.entity.Test;

public class WriteResultsResponse extends Response {

    Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
