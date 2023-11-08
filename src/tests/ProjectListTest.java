package src.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import src.DataWriter;
import src.Project;
import src.ProjectList;
import src.Section;
import src.User;
import src.UserList;
import src.statuses.CreateProjectStatus;
import src.statuses.DeleteProjectStatus;
import src.statuses.DeleteSectionStatus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectListTest {
    String title;

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
        User userOne = new User("asmith", "password", "asmith@gmail.com");
        Project project = new Project("Electric Missiles", userOne);
        project.title.equals(title);
        assert (project) != null;
    }

    @Test
    public void testDeleteProject()
    {
        ArrayList<Project> projects = new ArrayList<>();
        User userOne = new User("asmith", "password", "asmith@gmail.com");
        Project project = new Project("Electric Missiles", userOne);
        projects.remove(project);
        assertEquals(DeleteProjectStatus.SUCCESS, projects.remove(project));
    }

    @Test
    public void testCreateSection()
    {
        Section section = new Section("TODO");
        assertEquals("TODO", section.title);
    }

    @Test
    public void testRemoveSection()
    {
        Section section = new Section("TODO");
        User userOne = new User("asmith", "password", "asmith@gmail.com");
        Project currentProject = new Project("Electric Missiles", userOne);
        currentProject.deleteSection(section);
        assertEquals(DeleteSectionStatus.SUCCESS, currentProject.deleteSection(section));
    }
}
