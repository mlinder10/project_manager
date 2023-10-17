package src;

import java.util.ArrayList;

public class UserList {
    private static UserList list;
    private ArrayList<User> users;
    private User user;

    private UserList() {
        users = new ArrayList<User>();
        user = null;
    }

    public static ArrayList<User> getAllUsers() {
        if (list == null)
            return new UserList().users;
        return list.users;
    }

    public static User getCurrentUser() {
        if (list == null)
            return new UserList().user;
        return list.user;
    }

    public boolean register(String email, String username, String password) {
        User newUser = new User(username, password, email);
        users.add(newUser);
        return true;
    }

    public boolean login(String username, String password) {
        for (User userElement : users) {
            if (userElement.login(username, password)) {
                user = userElement;
                return true;
            }
        }
        return false;
    }

    public boolean logout() {
        user = null;
        return true;
    }
}