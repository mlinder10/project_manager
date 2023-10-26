package src;

import java.util.ArrayList;

import src.statuses.LoginStatus;
import src.statuses.RegisterStatus;

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

    public RegisterStatus register(String email, String username, String password) {
        // all empty
        if ((username == null || username.equals("")) && (password == null || password.equals(""))
                && (email == null || email.equals("")))
            return RegisterStatus.EMPTY_USERNAME_AND_PASSWORD_AND_EMAIL;

        // empty username and password
        if ((username == null || username.equals("")) && (password == null || password.equals("")))
            return RegisterStatus.EMPTY_USERNAME_AND_PASSWORD;

        // empty username and email
        if ((username == null || username.equals(""))
                && (email == null || email.equals("")))
            return RegisterStatus.EMPTY_USERNAME_AND_EMAIL;

        // empty email and password
        if ((password == null || password.equals(""))
                && (email == null || email.equals("")))
            return RegisterStatus.EMPTY_PASSWORD_AND_EMAIL;

        // empty username
        if (username == null || username.equals(""))
            return RegisterStatus.EMPTY_USERNAME;

        // empty password
        if (password == null || password.equals(""))
            return RegisterStatus.EMPTY_USERNAME;

        // empty email
        if (email == null || email.equals(""))
            return RegisterStatus.EMPTY_USERNAME;

        User newUser = new User(username, password, email);
        users.add(newUser);
        return RegisterStatus.SUCCESS;
    }

    public LoginStatus login(String username, String password) {
        if ((username == null || username.equals("")) && (password == null || password.equals("")))
            return LoginStatus.EMPTY_USERNAME_AND_PASSWORD;
        if (username == null || username.equals(""))
            return LoginStatus.EMPTY_USERNAME;
        if (password == null || password.equals(""))
            return LoginStatus.EMPTY_PASSWORD;
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