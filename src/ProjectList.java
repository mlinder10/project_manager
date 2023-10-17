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
        this.currentProject = currentProject;
        this.projects = projects;
    }

    public static ArrayList<Project> getAllProjects()
    {
        ArrayList<Project> projects = new ArrayList<Project>();
        return projects;
    }

    public static Project getCurrentProject() 
    {
        
        return null;
    }

    public boolean createProject(User user)
    {
        if(createProject(user) != true)
        {
            return false;
        }
        return true;
        
    }

    public boolean deleteProject()
    {
        if(deleteProject() == true)
        {
            return true;
        }
        return false;
    }

    public boolean addUser(User user)
    {
        if(addUser(user) != true)
        {
            return false;
        }
        return true;
    }
}
