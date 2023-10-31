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

    public static ProjectList getProjectList() {
        if (projectList == null)
            return new ProjectList();
        return projectList;
    }

    public static Project getCurrentProject() {
        return null;
    }

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
