package src.tests;

import org.junit.Test;

import src.User;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class UserListTest {

    @Test 
    public void register() {
        User user = new User("atticusmadden", "password", "");
        assertEquals("atticusmadden", user.username);
    }

    @Test 
    public void register2() {
        User user = new User("atticusmadden", "password", "amadden@gmail.com");
        assertEquals("amadden@gmail.com", user.email);
    }

    @Test 
    public void register3() {
        User user = new User("atticusmadden", "password", "amadden@gmail.com");
        assertEquals("password", user.getPassword());
    
    }

    @Test 
    public void login() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("atticusmadden", "password", "amadden@gmail.com");
        user.login("atticusmadden", "password");
        assertEquals(true, user.login("atticusmadden", "password"));
        
    }

    @Test 
    public void logout() {
        User user = new User("atticusmadden", "password", "amadden@gmail.com");
        user = null;
        assert (user) == null;
    }
}
