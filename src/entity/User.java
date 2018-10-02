package entity;

import org.mindrot.jbcrypt.BCrypt;

public class User {


    //properties

    private int userId;
    private String username;
    private String email;
    private String password;

    //constructors

    public User(int userId, String email, String username, String password) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.setPassword(password);
    }

    public User() {
    }

    //getter & setter

    public int getId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
