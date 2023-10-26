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
        projects.add(newProject);
        return true;
    }

    public boolean deleteProject(Project project) {
        projects.remove(project);
        return true;
    }

    public boolean createSection(String title) {
        return currentProject.createSection(new Section(title));
    }

    public boolean removeSection(Section section) {
        return currentProject.removeSection(section);
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
