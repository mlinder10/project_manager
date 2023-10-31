package src;

import src.statuses.AddUserStatus;
import src.statuses.CreateCommentStatus;
import src.statuses.CreateProjectStatus;
import src.statuses.CreateSectionStatus;
import src.statuses.CreateTaskStatus;
import src.statuses.DeleteCommentStatus;
import src.statuses.DeleteProjectStatus;
import src.statuses.DeleteSectionStatus;
import src.statuses.DeleteTaskStatus;
import src.statuses.LoginStatus;
import src.statuses.LogoutStatus;
import src.statuses.MoveTaskStatus;
import src.statuses.RegisterStatus;
import src.statuses.SaveDataStatus;

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

    public LogoutStatus logout() {
        return userList.logout();
    }

    public CreateProjectStatus createProject(String title) {
        return projectList.createProject(userList.user, title);
    }

    public DeleteProjectStatus deleteProject(Project project) {
        return projectList.deleteProject(project);
    }

    public CreateSectionStatus createSection(String title) {
        return projectList.createSection(title);
    }

    public DeleteSectionStatus deleteSection(Project project, Section section) {
        return project.deleteSection(section);
    }

    public CreateTaskStatus createTask(Section section, String title, String description, int priority, String type) {
        return section.createTask(new Task(title, description, priority, type));
    }

    public DeleteTaskStatus deleteTask(Section section, Task task) {
        return section.deleteTask(task);
    }

    public MoveTaskStatus moveTask(Section currentSection, Section nextSection, Task task) {
        if (currentSection.deleteTask(task) != DeleteTaskStatus.SUCCESS)
            return MoveTaskStatus.DELETE_ERROR;
        if (nextSection.createTask(task) != CreateTaskStatus.SUCCESS) {
            return MoveTaskStatus.CREATE_ERROR;
        }
        return MoveTaskStatus.SUCCESS;
    }

    public CreateCommentStatus createComment(Project project, String content, User user) {
        return project.createComment(new Comment(content, user));
    }

    public CreateCommentStatus createComment(Task task, String content, User user) {
        return task.createComment(new Comment(content, user));
    }

    public CreateCommentStatus createComment(Comment comment, String content, User user) {
        return comment.createComment(new Comment(content, user));
    }

    public DeleteCommentStatus deleteComment(Project project, Comment comment) {
        return project.deleteComment(comment);
    }

    public DeleteCommentStatus deleteComment(Task task, Comment comment) {
        return task.deleteComment(comment);
    }

    public DeleteCommentStatus deleteComment(Comment rootComment, Comment comment) {
        return rootComment.deleteComment(comment);
    }

    public AddUserStatus addUserToProject(User user, Project project) {
        return project.addUser(user);
    }

    public boolean addAssignedUser(Task task, User user) {
        return task.addAssignedUser(user);
    }

    public boolean removeAssignedUser(Task task, User user) {
        return task.removeAssignedUser(user);
    }

    public SaveDataStatus saveData() {
        boolean userRes = DataWriter.saveUsers(userList.users);
        boolean projectRes = DataWriter.saveProjects(projectList.projects);
        if (userRes && projectRes)
            return SaveDataStatus.SUCCESS;
        else
            return SaveDataStatus.FAILURE;
    }
}
