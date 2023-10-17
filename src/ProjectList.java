package src;
/**
 * @author Gavin Orme
 */

import java.util.ArrayList;

public class ProjectList 
{
    private ArrayList<Project> projects;
    Project currentProject;

    private ProjectList()
    {
        
    }

    public static ArrayList<Project> getAllProjects()
    {
        ArrayList<Project> projects = new ArrayList<Project>();
        return projects;
    }

    public static Project getCurrentProject() 
    {
        Project project = ProjectList.getCurrentProject();
        return project;
    }

    public boolean createProject(User user)
    {
        return true;
    }

    public boolean deleteProject()
    {
        return false;
    }

    public boolean addUser(User user)
    {
        return true;
    }
}
