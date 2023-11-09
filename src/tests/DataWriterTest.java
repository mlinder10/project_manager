package src.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.DataLoader;
import src.DataWriter;
import src.Project;
import src.ProjectList;
import src.User;
import src.UserList;


import java.util.ArrayList;

public class DataWriterTest {

    private ArrayList<User> users = UserList.getUserList().users;
    private ArrayList<Project> projects = ProjectList.getProjectList().projects;

    @Before
    public void setup() {
        users.clear();
        DataWriter.saveUsers(users);

    }

    @After
    public void tearDown() {
        users.clear();
        DataWriter.saveUsers(users);
    }

    @Test
    public void testWritingEmpty(){
        users = DataLoader.loadUsers();
        assertEquals(0, users.size());
    }

    @Test
    public void testWritingOneUser() {
        users.add(new User("hill", "12345678", "ahill@gmail.com"));
        DataWriter.saveUsers(users);
        assertEquals("hill", DataLoader.loadUsers().get(0).username);
    }

    @Test
    public void testNoEmailAddress(){
        users.clear();
        users.add(new User("grey", "10987654", ""));
        DataWriter.saveUsers(users);
        assertEquals("", DataLoader.loadUsers().get(0));
    }

    @Test
    public void testNoUsername(){
        users.clear();
        users.add(new User("grey", "10987654", "ho@gmail.com"));
        users.add(new User("", "67599000", "ag@gmail.com"));
        DataWriter.saveUsers(users);
        assertEquals("", DataLoader.loadUsers().get(1));
    }

    @Test
    public void testNoProjectName(){
        projects.clear();
        User max = new User("max", "8432234567", "hot@hotmail.com");
        projects.add(new Project("", max));
        DataWriter.saveProjects(projects);
        assertEquals("", DataLoader.loadProjects().get(0));
    }
    @Test
    public void testAddOneProject(){
        projects.clear();
        User kim = new User("kimmmy", "mrtakeyobish23", "topofthemorning@email.sc.edu");
        projects.add(new Project("num1", kim));
        DataWriter.saveProjects(projects);
        assertEquals("num1", DataLoader.loadProjects().get(0).title);
    }





}
