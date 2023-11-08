package src.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import src.DataWriter;
import src.Project;
import src.ProjectList;
import src.User;
import src.UserList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectListTest {
    // public ProjectList projectList = new ProjectList();
    // private ArrayList<Project> ProjectList = ProjectList.getProjectList();
    // public Project currentProject = new Project.getProjects();
    private ArrayList<User> users = UserList.getUserList().users;
    private ArrayList<Project> projectList = ProjectList.getProjectList().projects;

    // @BeforeEach
    // public void setup()
    // {
    //     users.clear();
	// 	projectList.clear();

    //     User userOne = new User("asmith", "password", "asmith@gmail.com");
	// 	User userTwo = new User("bwhite", "password", "bwhite@gmail.com");

	// 	users.add(userOne);
	// 	users.add(userTwo);

    //     projectList.add(new Project("project1", userOne));
    //     projectList.add(new Project("project2", userTwo));
    //     DataWriter.saveUsers(users);
    //     DataWriter.saveProjects(projectList);
    // }

    // @AfterEach
    // public void tearDown()
    // {
    //     projectList.clear();
    //     DataWriter.saveProjects(projectList);
    // }

    @Test
    public void testCreateProject()
    {
        User userOne = new User("asmith", "password", "asmith@gmail.com");
        Project project = new Project("Electric Missiles", userOne);
        assertEquals("Electric Missiles", project.title);
    }

    @Test
    public void testOpenProject()
    {

    }

    @Test
    public void testDeleteProject()
    {

    }

    @Test
    public void testCreateSection()
    {

    }

    @Test
    public void testRemoveSection()
    {
        
    }
}
