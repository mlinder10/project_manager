package src;

/**
 * @author Gavin Orme
 */

import java.util.ArrayList;
public class ProjectList {
    private static ProjectList projectList;
    public ArrayList<Project> projects;
    public Project currentProject;

    private ProjectList() {
        this.projects = new ArrayList<Project>();
        this.currentProject = null;
    }

    public static ProjectList getProjectList() {
        if (projectList == null)
            return new ProjectList();
        return projectList;
    }

<<<<<<< HEAD
    public static Project getCurrentProject() 
    {
        return null;
    }

    public boolean createProject(User user)
    {
=======
    public boolean createProject(User user, String title) {
        Project newProject = new Project(title, user);
        projects.add(newProject);
>>>>>>> 5418ffb6109c41381565598c23cc758d8c110998
        return true;
    }

    public boolean deleteProject(Project project) {
        projects.remove(project);
        return true;
    }

    public boolean addUser(User user, Project project) {
        for (Project projectElement : projects) {
            if (project.id.equals(projectElement.id)) {
                project.users.add(user);
            }
        }
        return true;
    }
}
