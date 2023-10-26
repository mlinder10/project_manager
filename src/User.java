package src;

import java.util.UUID;

public class User {

    public static void main(String[] args) {
        User user1 = new User("jim", "jones", "jj@gmail.com");
        System.out.println(user1.email);
    }

    public UUID id;
    public String username;
    public String password;
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
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getPassword() {
        return password;
    }
    
}
