package src;

/**
 * @author Gavin Orme
 */

import java.util.ArrayList;
import src.statuses.CreateProjectStatus;
import src.statuses.DeleteProjectStatus;

public class ProjectList {

    private static ProjectList projectList;
    public ArrayList<Project> projects;
    public Project currentProject;

    private ProjectList() {
        this.projects = DataLoader.loadProjects();
        System.out.println(this.projects.size());
        this.currentProject = null;
    }

    public static ProjectList getProjectList() {
        if (projectList == null)
            return new ProjectList();
        return projectList;
    }

    public static Project getCurrentProject() {
        return null;
    }

    public boolean createProject(User user, String title) {
        Project newProject = new Project(title, user);
        if(projects.add(newProject))
            return true;
        else
            return false;
    }

    public DeleteProjectStatus deleteProject(Project project) {
        if(project = null){
            
        }
        if (projects.remove(project))
            return true;
        else 
            return false;
    }

    public boolean createSection(String title) {
        return currentProject.createSection(new Section(title));
    }

    public boolean removeSection(Section section) {
        return currentProject.removeSection(section);
    }
}
