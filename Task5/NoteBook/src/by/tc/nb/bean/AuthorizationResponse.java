package by.tc.nb.bean;

import by.tc.nb.bean.entity.User;

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
