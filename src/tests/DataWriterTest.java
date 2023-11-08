package src.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import src.UserList;


import java.util.ArrayList;

public class DataWriterTest {

    private ArrayList<User> users = UserList.getUserList();

    @Before

    public void setup() {
        UserList.getUserList().clear();
        DataWriter.saveUsers();

    }

    @After

    public void tearDown() {
        UserList.getUserList().clear();
        DataWriter.saveUsers();
    }

    @Test

    public void testWritingZeroUsers(){
        userList = DataLoader.loadUsers();
        assertEquals(0, userList.size());
    }

    @Test

    public void testWritingOneUser() {
        users.add(new User("hill", "12345678"));
        DataWriter.saveUsers();
        assertEquals("hill", DataLoader.loadUsers().get(0).username);
    }



}
