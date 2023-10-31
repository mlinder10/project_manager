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
        return projectList.currentProject;
    }

    public static Project openProject(String title) {
        for (Project project : projectList.projects) {
            if (project.title.equals(title)) {
                projectList.currentProject = project;
                return project;
            }
        }
        return null;
    }

    public static CreateProjectStatus createProject(User user, String title) {
        Project newProject = new Project(title, user);
        projectList.projects.add(newProject);
        return CreateProjectStatus.SUCCESS;
    }

    public static DeleteProjectStatus deleteProject(Project project) {
        projectList.projects.remove(project);
        return DeleteProjectStatus.SUCCESS;
    }

    public static CreateSectionStatus createSection(String title) {
        return projectList.currentProject.createSection(new Section(title));
    }

    public static DeleteSectionStatus removeSection(Section section) {
        return projectList.currentProject.deleteSection(section);
    }
}
