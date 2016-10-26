package by.tc.tm.bean;

import by.tc.tm.bean.entity.User;

public class AuthorizationResponse extends Response {

    private User user;

    public AuthorizationResponse() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
