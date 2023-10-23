package src;

import java.util.UUID;

public class User {

    public UUID id;
    public String username;
    private String password;
    public String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.id = UUID.randomUUID();
    }

    public User(UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean login(String username, String password) {
        return this.username == username && this.password == password;
    }

    public String getPassword() {
        return password;
    }
}
