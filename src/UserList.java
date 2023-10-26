package src;

import java.util.ArrayList;

import src.statuses.LoginStatus;

public class UserList {

    private static UserList list;
    public ArrayList<User> users;
    public User user;

    private UserList() {
        users = DataLoader.loadUsers();
        user = null;
    }

    public static UserList getUserList() {
        if (list == null)
            return new UserList();
        return list;
    }

    public boolean register(String email, String username, String password) {
        User newUser = new User(username, password, email);
        users.add(newUser);
        return true;
    }

    public LoginStatus login(String username, String password) {
        if ((username == null || username.equals("")) && (password == null || password.equals(""))) return LoginStatus.EMPTY_USERNAME_AND_PASSWORD;
        if (username == null || username.equals("")) return LoginStatus.EMPTY_USERNAME;
        if (password == null || password.equals("")) return LoginStatus.EMPTY_PASSWORD;
        for (User userElement : users) {
            if (userElement.login(username, password)) {
                user = userElement;
                return LoginStatus.SUCCESS;
            }
        }
        return LoginStatus.INVALID_CREDENTIALS;
    }

    public boolean logout() {
        user = null;
        return true;
    }
}