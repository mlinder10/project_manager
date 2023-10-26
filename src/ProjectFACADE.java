package src;

import src.statuses.CreateProjectStatus;
import src.statuses.LoginStatus;
import src.statuses.RegisterStatus;

public class ProjectFACADE {
    private UserList userList;
    private ProjectList projectList;

    public ProjectFACADE() {
        this.userList = UserList.getUserList();
        this.projectList = ProjectList.getProjectList();
    }

    public Project getCurrentProject() {
        return projectList.currentProject;
    }

    public LoginStatus login(String username, String password) {
        return userList.login(username, password);
    }

    public RegisterStatus register(String username, String password, String email) {
        return userList.register(password, username, email);
    }

    public CreateProjectStatus createProject(String title) {
        return projectList.createProject(userList.user, title);
    }

    public DeleteProjectStatus deleteProject(Project project) {
        return projectList.deleteProject(project);
    }

    public boolean createSection(String title) {
        return projectList.createSection(title);
    }

    public boolean removeSection(Project project, Section section) {
        return project.removeSection(section);
    }

    public boolean createTask(Section section, String title, String description, int priority, String type) {
        return section.createTask(new Task(title,description,priority,type));
    }

    public boolean delete(Section section, Task task) {
        return section.removeTask(task);
    }

    public boolean moveTask(Section currentSection, Section nextSection, Task task) {
        if (!currentSection.removeTask(task))
            return false;
        return nextSection.createTask(task);
    }

    public boolean createComment(Project project, String content, User user) {
        return project.addComent(new Comment(content, user));
    }

    public boolean createComment(Task task, String content, User user) {
        return task.addComment(new Comment(content, user));
    }

    public boolean createComment(Comment comment, String content, User user) {
        return comment.addComment(new Comment(content, user));
    }

    public boolean deleteComment(Project project, Comment comment) {
        return project.deleteComment(comment);
    }

    public boolean deleteComment(Task task, Comment comment) {
        return task.deleteComment(comment);
    }

    public boolean deleteComment(Comment rootComment, Comment comment) {
        return rootComment.deleteComment(comment);
    }

    public boolean addUserToProject(User user, Project project) {
        return project.addUser(user);
    }

    public boolean saveData() {
        boolean userRes = DataWriter.saveUsers(userList.users);
        boolean projectRes = DataWriter.saveProjects(projectList.projects);
        return userRes && projectRes;
    }
}
