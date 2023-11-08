package src.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.DataLoader;
import src.DataWriter;
import src.User;
import src.UserList;


import java.util.ArrayList;

public class DataWriterTest {

    private ArrayList<User> users = UserList.getUserList().users;

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
    public void testWritingZeroUsers(){
        users = DataLoader.loadUsers();
        assertEquals(0, users.size());
    }

    @Test
    public void testWritingOneUser() {
        users.add(new User("hill", "12345678", "ahill@gmail.com"));
        DataWriter.saveUsers(users);
        assertEquals("hill", DataLoader.loadUsers().get(0).username);
    }



}
