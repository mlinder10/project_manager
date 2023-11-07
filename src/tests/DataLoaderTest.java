package src.tests;


import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.DataLoader;
import src.DataWriter;
import src.Project;
import src.ProjectList;
import src.User;
import src.UserList;

public class DataLoaderTest {
	private ArrayList<User> users = UserList.getUserList().users;
	private ArrayList<Project> projects = ProjectList.getProjectList().projects;
	
	@Before
	public void setup() {
		users.clear();
		projects.clear();

		User userOne = new User("asmith", "password", "asmith@gmail.com");
		User userTwo = new User("bwhite", "password", "bwhite@gmail.com");

		users.add(userOne);
		users.add(userTwo);
		
		projects.add(new Project("project one", userOne));
		projects.add(new Project("project two", userTwo));

		DataWriter.saveUsers(users);
		DataWriter.saveProjects(projects);
	}
	
	@After
	public void tearDown() {
		users.clear();
		DataWriter.saveUsers(users);
	}
	
	@Test
	public void testGetUsersSize() {
		users = DataLoader.loadUsers();
		assertEquals(2, users.size());
	}

	@Test
	public void testGetUsersSizeZero() {
		users.clear();
		DataWriter.saveUsers(users);
		assertEquals(0, users.size());
	}
	
	@Test
	public void testGetRootUserValue() {
		users = DataLoader.loadUsers();
		assertEquals("asmith", users.get(0).username);
	}

	@Test
	public void testGetProjectsSize() {
		assertEquals(2, projects.size());
	}

	@Test
	public void testGetProjectsSizeZero() {
		projects.clear();
		assertEquals(0, projects.size());
	}

	@Test
	public void testGetRootProjectValue() {
		assertEquals("project one", projects.get(0).title);
	}

	@Test
	public void testGetDeepProjectValue() {
		assertEquals("asmith@gmail.com", projects.get(0).owner.email);
	}
}
