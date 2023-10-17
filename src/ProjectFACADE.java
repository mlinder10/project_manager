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

    public Project getCurrentProject(){
        currentProject = ProjectList.getCurrentProject();
        return currentProject;
    } 

    public Project getCurrentProject() {
        return ProjectList.project;
    }

    public boolean createProject(){
        return true;
    }

    public boolean addUserToProject() {
        return true;
    }
}
