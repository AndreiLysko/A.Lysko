package by.tc.nb.bean;

public class AuthorizationRequest extends Request{

    private String username;
    private String password;

    public AuthorizationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
