package by.tc.tm.bean.entity;

public class User {

    private final int id;
    private final String username;
    private int priviledge;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(int id, String username, int priviledge) {
        this.id = id;
        this.username = username;
        this.priviledge = priviledge;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getPriviledge() {
        return priviledge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (priviledge != user.priviledge) return false;
        return username.equals(user.username);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + username.hashCode();
        result = 31 * result + priviledge;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", priviledge=" + priviledge +
                '}';
    }
}
