package src.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import src.Project;
import src.User;


public class ProjectTest {
 
    private String title;

    @Test 
    public void editProjectTitle() {
        User user = new User("atticusmadden", "password", "amadden@gmail.com");
        Project project = new Project("Electric Missles", user);
        this.title = "hi";
        assertEquals("hi", title);
    }

    @Test 
    public void createSection() {
        
    }

    @Test 
    public void deleteSection() {
        
    }

    @Test 
    public void addUser() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("atticusmadden", "password", "amadden@gmail.com");
        users.add(user);
        assertEquals(true, users.add(user));
    }

    @Test 
    public void createComment() {
        
    }

    @Test 
    public void deleteComment() {
        
    }
}
