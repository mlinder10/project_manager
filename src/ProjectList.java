package src;

/**
 * @author Gavin Orme
 */

import java.util.ArrayList;

public class ProjectList {

    public static void main(String args[]) {
        ProjectList p = new ProjectList();
        p.createProject(null, null);
        p.deleteProject(getCurrentProject());
        p.addUser(null, getCurrentProject());
    }

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

    public static Project getCurrentProject() 
    {
        return null;
    }

    public boolean createProject(User user, String title) {
        Project newProject = new Project(title, user);
        projects.add(newProject);
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
