package src;
/**
 * @author Gavin Orme
 */

import java.util.ArrayList;

public class ProjectList 
{
    public ArrayList<Project> projects;
    public Project currentProject;
    private static ProjectList projectList;

    private ProjectList()
    {
        projects = new ArrayList<Project>();
        currentProject = null;
    }

    public static ArrayList<Project> getAllProjects()
    {
        if(projectList == null)
            return new ProjectList().projects;
        return projectList.projects;
    }

    public static Project getCurrentProject() 
    {
        if(projectList == null)
            return new ProjectList().currentProject;
        return projectList.currentProject;
    }

    public boolean createProject(User user)
    {
        Project creatProject = new Project();
    
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
