package src;

public class ProjectFACADE {
    private UserList userList;
    private ProjectList projectList;

    public ProjectFACADE() {
        this.userList = UserList.getUserList();
        this.projectList = ProjectList.getProjectList();
    }

    public boolean login(String username, String password) {
        return userList.login(username, password);
    }

    public boolean register(String username, String password, String email) {
        return userList.register(password, username, email);
    }

    public boolean createProject(String title) {
        return projectList.createProject(userList.user, title);
    }

    public boolean deleteProject(Project project) {
        return true;
    }

    public boolean createSection(Project project, String title) {
        return true;
    }

    public boolean removeSection(Project project, Section section) {
        return true;
    }

    public boolean createTask(Section section, String title, String description, int priority, String type) {
        return true;
    }

    public boolean removeTask(Section section, Task task) {
        return true;
    }

    public boolean moveTask(Section currentSection, Section nextSection, Task task) {
        return true;
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
