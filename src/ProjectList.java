package src;

/**
 * @author Gavin Orme
 */

import java.util.ArrayList;
import src.statuses.CreateProjectStatus;
import src.statuses.DeleteProjectStatus;
import src.statuses.DeleteSectionStatus;

public class ProjectList {

    private static ProjectList projectList;
    public ArrayList<Project> projects;
    public Project currentProject;

    private ProjectList() {
        this.projects = DataLoader.loadProjects();
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
        return currentProject;
    }

    /**
     * Opens the project if the title matches the project title
     * @param title this is the title of the current project
     * @return returns nothing 
     */
    public Project openProject(String title) {
        for (Project project : projects) {
            if (project.title.equals(title)) {
                currentProject = project;
                return project;
            }
        }
        return null;
    }

    /**
     * Allows the user to create a project 
     * @param user This is the current user accesing the new project
     * @param title This is the title of the new project
     * @return returns a new project with the user who created the project and the name of it
     */
    public CreateProjectStatus createProject(User user, String title) {
        Project newProject = new Project(title, user);
        projects.add(newProject);
        return CreateProjectStatus.SUCCESS;
    }

    /**
     * Removes the project when prompted and gives a success message after deleting
     * @param project This is the project that is going to be deleted
     * @return returns the success of deleting the project
     */
    public DeleteProjectStatus deleteProject(Project project) {
        projects.remove(project);
        return DeleteProjectStatus.SUCCESS;
    }

    public Section createSection(String title) {
        Section section = new Section(title);
        currentProject.createSection(section);
        return section;
    }

    /**
     * Allows the user to remove a section inside the project
     * @param section this is the section inside the project that is going to be removed
     * @return returns a deleted section
     */
    public DeleteSectionStatus removeSection(Section section) {
        return currentProject.deleteSection(section);
    }
}
