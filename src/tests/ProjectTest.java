package src.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import src.Comment;
import src.Project;
import src.User;
import src.Section;
import src.User;
import src.statuses.CreateSectionStatus;


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
        ArrayList<Section> sections = new ArrayList<>();
        Section section = new Section("TODO");
        sections.add(section);
        assertEquals(true, sections.add(section));
    }

    @Test 
    public void deleteSection() {
        ArrayList<Section> sections = new ArrayList<>();
        Section section = new Section("TODO");
        sections.add(section);
        assertEquals(true, sections.remove(section));
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
        ArrayList<Comment> comments = new ArrayList<>();
        User userOne = new User("asmith", "password", "asmith@gmail.com");
        Comment comment = new Comment("Make impossible burger possible", userOne);
        comments.add(comment);
        assertEquals(true, comments.add(comment));
    }

    @Test 
    public void deleteComment() {
        ArrayList<Comment> comments = new ArrayList<>();
        User userOne = new User("asmith", "password", "asmith@gmail.com");
        Comment comment = new Comment("Make impossible burger possible", userOne);
        comments.add(comment);
        assertEquals(true, comments.remove(comment));
    }
}
