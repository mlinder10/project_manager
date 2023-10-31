package src;

/**
 * @author Gavin Orme
 */

import java.util.ArrayList;
import src.statuses.CreateProjectStatus;
import src.statuses.CreateSectionStatus;
import src.statuses.DeleteProjectStatus;
import src.statuses.DeleteSectionStatus;

public class ProjectList {

    private static ProjectList projectList;
    public ArrayList<Project> projects;
    public Project currentProject;

    private ProjectList() {
        this.projects = DataLoader.loadProjects();
        System.out.println(this.projects.size());
        this.currentProject = null;
    }

    /**
     * This creates a list of projects if there is not one already
     * @return returns a new project list
     */
    public static ProjectList getProjectList() {
        if (projectList == null)
            return new ProjectList();
        return projectList;
    }

    /**
     * Takes you to the current project you are working on
     * @return returns the current project
     */
    public Project getCurrentProject() {
        return projectList.currentProject;
    }

    /**
     * Allows the user to create a project 
     * @param user This is the current user accesing the new project
     * @param title This is the title of the new project
     * @return returns a new project with the user who created 
     */
    public CreateProjectStatus createProject(User user, String title) {
        Project newProject = new Project(title, user);
        projects.add(newProject);
        return CreateProjectStatus.SUCCESS;
    }

    public DeleteProjectStatus deleteProject(Project project) {
        projects.remove(project);
        return DeleteProjectStatus.SUCCESS;
    }

    public CreateSectionStatus createSection(String title) {
        return currentProject.createSection(new Section(title));
    }

    public DeleteSectionStatus removeSection(Section section) {
        return currentProject.deleteSection(section);
    }
}
