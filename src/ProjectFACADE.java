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
        projectList.createProject(userList.user, title);
        return true;
    }

    public boolean addUserToProject(User user, Project project) {
        projectList.addUser(user, project);
        return true;
    }

    public boolean saveData() {
        DataWriter.saveUsers(userList.users);
        DataWriter.saveProjects(projectList.projects);
        return true;
    }
}
