package src;

import java.util.ArrayList;

import src.statuses.LoginStatus;
import src.statuses.LogoutStatus;
import src.statuses.RegisterStatus;

/**
 * Creates an array list of users 
 */
public class UserList {

    private static UserList list;
    public ArrayList<User> users;
    public User user;

    private UserList() {
        users = DataLoader.loadUsers();
        user = null;
    }

    /**
     * Returns the array list of users 
     * @return returns the list of users it if is not null 
     */
    public static UserList getUserList() {
        if (list == null)
            return new UserList();
        return list;
    }

    /**
     * Regesters a new user by a username, email, and password 
     * @param email holds the email of the user in a string
     * @param username holds the username of the user in a string
     * @param password holds the password of the user in a string
     * @return returns a different status depending on information entered 
     */
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
            return RegisterStatus.EMPTY_PASSWORD;

        // empty email
        if (email == null || email.equals(""))
            return RegisterStatus.EMPTY_EMAIL;

        // username taken
        for (User user : users) {
            if (user.username.equals(username))
                return RegisterStatus.USERNAME_TAKEN;
        }

        // short password
        if (password.length() < 8)
            return RegisterStatus.INVALID_PASSWORD;

        User newUser = new User(username, password, email);
        users.add(newUser);
        return RegisterStatus.SUCCESS;
    }

    /**
     * Logs in a user when they use the correct credentials 
     * @param username holds the username of the user in a string
     * @param password holds the password of the user in a string
     * @return returns a different status based on information entered 
     */
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

    /**
     * Logs out a user 
     * @return returns successesfull on logout 
     */
    public LogoutStatus logout() {
        user = null;
        return LogoutStatus.SUCCESS;
    }
}