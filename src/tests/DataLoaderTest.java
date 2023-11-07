package src.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;

import src.DataLoader;
import src.DataWriter;
import src.User;
import src.UserList;

class DataLoaderTest {
	private ArrayList<User> users = UserList.getUserList().users;
	
	// @BeforeEach
	public void setup() {
		users.clear();
		users.add(new User("asmith", "password", "asmith@gmail.com"));
		users.add(new User("bwhite", "password", "asmith@gmail.com"));
		DataWriter.saveUsers(users);
	}
	
	// @AfterEach
	public void tearDown() {
		users.clear();
		DataWriter.saveUsers(users);
	}
	
	
	@Test
	void testGetUsersSize() {
		users = DataLoader.loadUsers();
		assertEquals(2, users.size());
	}

	@Test
	void testGetUsersSizeZero() {
		users.clear();
		DataWriter.saveUsers(users);
		assertEquals(0, users.size());
	}
	
	@Test
	void testGetUserFirstUserName() {
		users = DataLoader.loadUsers();
		assertEquals("asmith", users.get(0).username);
	}
}
