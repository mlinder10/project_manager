package src;

import src.statuses.LoginStatus;

public class ProjectFacade {
    private UserList userList;
    private ProjectList projectList;

    public ProjectFacade() {
        this.userList = UserList.getUserList();
        this.projectList = ProjectList.getProjectList();
    }

    public Project getCurrentProject() {
        return projectList.currentProject;
    }

    public LoginStatus login(String username, String password) {
        return userList.login(username, password);
    }

    public boolean register(String username, String password, String email) {
        return userList.register(password, username, email);
    }

    public boolean createProject(String title) {
        return projectList.createProject(userList.user, title);
    }

    public boolean deleteProject(Project project) {
        return projectList.deleteProject(project);
    }

    public boolean createSection(String title) {
        return projectList.createSection(title);
    }

    public boolean removeSection(Project project, Section section) {
        
    }

    public boolean createTask(Section section, String title, String description, int priority, String type) {
        
        Task newTask= new Task(title,description,priority,type);
        section.addTask(newTask);
        return true;

    }

    public boolean removeTask(Section section, Task task) {
        section.removeTask(task);
        return true;
    }

    public boolean moveTask(Section currentSection, Section nextSection, Task task) {
        currentSection.removeTask(task);
        nextSection.addTask(task);
    }

    public boolean addUserToProject(User user, Project project) {
        return projectList.addUser(user, project);
    }

    public boolean saveData() {
        boolean userRes = DataWriter.saveUsers(userList.users);
        boolean projectRes = DataWriter.saveProjects(projectList.projects);
        return userRes && projectRes;
    }
}
