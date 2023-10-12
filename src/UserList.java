package src;
import java.util.ArrayList;

public class UserList {

    private ArrayList<User> users;
    private User user;

    private UserList() {

    }

    public ArrayList<User> getAllUsers() {
        return users;
       
    }

    public User getCurrentUser() {
        return user;

    }

    public boolean register(String email, String username, String password) {
        return false;

    }

    public boolean login (String username, String password) {
        return false;

    }

    public boolean logout() {
        return false;

    }
}