package src.tests;

import org.junit.jupiter.Assertions.*;
import org.junit.Test;

import org.junit.jupiter.api.BeforeEach;

import src.UserList;

import org.junit.jupiter.api.AfterEach;
import java.util.ArrayList;

public class DataWriterTest {

    private ArrayList<User> users = UserList.getUserList();

    @BeforeEach

    public void setup() {
        UserList.getUserList().clear();
        DataWriter.saveUsers();

    }

    @AfterEach

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
