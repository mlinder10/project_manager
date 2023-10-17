package src;

import java.util.UUID;

public class User {

    public UUID id;
    public String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        
    }

    public User(String id)
    {
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
}
