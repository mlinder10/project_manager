package src;
/**
 * @author Alex Brown
 */
import src.statuses.AddUserStatus;
import src.statuses.CreateCommentStatus;
import src.statuses.CreateProjectStatus;
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

/**
 * Facade for project
 */
public class ProjectFACADE {
    private UserList userList;
    private ProjectList projectList;

    /**
     * Contrustor cretes new user list and project list
     */
    public ProjectFACADE() {
        this.userList = UserList.getUserList();
        this.projectList = ProjectList.getProjectList();
    }

    /**
     * Gets project currently being worked on
     * 
     * @return current project
     */
    public Project getCurrentProject() {
        return projectList.currentProject;
    }

    /**
     * Logs in user
     * 
     * @param username
     * @param password
     * @return login status
     */
    public LoginStatus login(String username, String password) {
        return userList.login(username, password);
    }

    /**
     * Registers new user
     * 
     * @param username
     * @param password
     * @param email
     * @return regerster status
     */
    public RegisterStatus register(String username, String password, String email) {
        return userList.register(password, username, email);
    }

    /**
     * logs user out
     * 
     * @return logout status
     */
    public LogoutStatus logout() {
        return userList.logout();
    }

    /**
     * gets project
     * 
     * @param title
     * @return project
     */
    public Project getProject(String title) {
        return projectList.openProject(title);
    }

    /**
     * opens project
     * 
     * @param title
     * @return project
     */
    public Project openProject(String title) {
        return projectList.openProject(title);
    }

    /**
     * Makes new project
     * 
     * @param title
     * @return If project is created
     */
    public CreateProjectStatus createProject(String title) {
        return projectList.createProject(userList.user, title);
    }

    /**
     * Deletes project
     * 
     * @param project
     * @return If project is deleted
     */
    public DeleteProjectStatus deleteProject(Project project) {
        return projectList.deleteProject(project);
    }

    /**
     * Creates section
     * 
     * @param title
     * @return Section
     */
    public Section createSection(String title) {
        Section section = new Section(title);
        projectList.currentProject.sections.add(section);
        return section;
    }

    /**
     * Gets section based on title
     * 
     * @param title
     * @return Section
     */
    public Section getSection(String title) {
        for (Section section : projectList.currentProject.sections) {
            if (section.title.equals(title))
                return section;
        }
        return null;
    }

    /**
     * deletes a section
     * 
     * @param project
     * @param section
     * @return If section is delted
     */
    public DeleteSectionStatus deleteSection(Project project, Section section) {
        return project.deleteSection(section);
    }

    /**
     * creates a task
     * 
     * @param sectionTitle
     * @param title
     * @param description
     * @param priority
     * @param type
     * @return Task
     */
    public Task createTask(String sectionTitle, String title, String description, int priority, String type) {
        Task task = new Task(title, description, priority, type);
        projectList.currentProject.getSection(sectionTitle).createTask(task);
        return task;
    }

    /**
     * creates a task
     * 
     * @param section
     * @param title
     * @param description
     * @param priority
     * @param type
     * @return If task is created
     */
    public CreateTaskStatus createTask(Section section, String title, String description, int priority, String type) {
        return section.createTask(new Task(title, description, priority, type));
    }

    /**
     * moves task
     * 
     * @param taskTitle
     * @param sectionTitle
     * @return
     */
    public boolean moveTask(String taskTitle, String sectionTitle) {
        Section oldSection = null;
        Task movingTask = null;
        for (Section section : projectList.currentProject.sections) {
            for (Task task : section.tasks) {
                if (task.title.equals(taskTitle)) {
                    oldSection = section;
                    movingTask = task;
                }
            }
        }

        if (oldSection == null)
            return false;
        oldSection.tasks.remove(movingTask);
        getSection(sectionTitle).createTask(movingTask);

        return true;
    }

    /**
     * Deletes task
     * 
     * @param section
     * @param task
     * @return if task is deleted
     */
    public DeleteTaskStatus deleteTask(Section section, Task task) {
        return section.deleteTask(task);
    }

    /**
     * Moves task
     * 
     * @param currentSection
     * @param nextSection
     * @param task
     * @return if task is moved
     */
    public MoveTaskStatus moveTask(Section currentSection, Section nextSection, Task task) {
        if (currentSection.deleteTask(task) != DeleteTaskStatus.SUCCESS)
            return MoveTaskStatus.DELETE_ERROR;
        if (nextSection.createTask(task) != CreateTaskStatus.SUCCESS) {
            return MoveTaskStatus.CREATE_ERROR;
        }
        return MoveTaskStatus.SUCCESS;
    }

    /**
     * creates a comment on project
     * 
     * @param project
     * @param content
     * @param user
     * @return CreateCommentStatus
     */
    public CreateCommentStatus createComment(Project project, String content, User user) {
        return project.createComment(new Comment(content, user));
    }

    /**
     * creates comment on task
     * 
     * @param task
     * @param content
     * @return CreateCommentStatus
     */
    public CreateCommentStatus createComment(Task task, String content) {
        System.out.println(userList.user);
        return task.createComment(new Comment(content, userList.user));
    }

    /**
     * create comment on comment
     * 
     * @param comment
     * @param content
     * @return CreateCommentStatus
     */
    public CreateCommentStatus createComment(Comment comment, String content) {
        return comment.createComment(new Comment(content, userList.user));
    }

    /**
     * deletes comment on project
     * 
     * @param project
     * @param comment
     * @return if comment is deleted
     */
    public DeleteCommentStatus deleteComment(Project project, Comment comment) {
        return project.deleteComment(comment);
    }

    /**
     * deletes comment on task
     * 
     * @param task
     * @param comment
     * @return if comment is delted
     */
    public DeleteCommentStatus deleteComment(Task task, Comment comment) {
        return task.deleteComment(comment);
    }

    /**
     * deletes comment on coment
     * 
     * @param rootComment
     * @param comment
     * @return if comment is deleted
     */
    public DeleteCommentStatus deleteComment(Comment rootComment, Comment comment) {
        return rootComment.deleteComment(comment);
    }

    /**
     * adds user to project
     * 
     * @param user
     * @param project
     * @return if user is added
     */
    public AddUserStatus addUserToProject(User user, Project project) {
        return project.addUser(user);
    }

    /**
     * adds user to task
     * 
     * @param task
     * @param user
     * @return if user is added
     */
    public boolean addAssignedUser(Task task, User user) {
        return task.addAssignedUser(user);
    }

    /**
     * removes user from task
     * 
     * @param task
     * @param user
     * @return if user is removed
     */
    public boolean removeAssignedUser(Task task, User user) {
        return task.removeAssignedUser(user);
    }

    /**
     * saves data
     * 
     * @return if data is saved
     */
    public SaveDataStatus saveData() {
        boolean userRes = DataWriter.saveUsers(userList.users);
        boolean projectRes = DataWriter.saveProjects(projectList.projects);
        if (userRes && projectRes)
            return SaveDataStatus.SUCCESS;
        else
            return SaveDataStatus.FAILURE;
    }

    public Task getTask(String title) {
        for (Section section : projectList.currentProject.sections) {
            for (Task task : section.tasks) {
                if (task.title.equals(title))
                    return task;
            }
        }

        return null;
    }

    public boolean moveTask(Task targetTask, String sectionTitle) {
        Section targetSection = null;
        for (Section section : projectList.currentProject.sections) {
            if (section.title.equals(sectionTitle)) {
                createTask(section, targetTask.title, targetTask.description, targetTask.priority, targetTask.type);
            }
            for (Task task : section.tasks) {
                if (task.id.equals(targetTask.id)) {
                    targetSection = section;
                }
            }
        }
        targetSection.tasks.remove(targetTask);
        return true;
    }

    public User getUser() {
        return userList.user;
    }

    public User getUser(String username) {
        for (User user : userList.users) {
            if (user.username.equals(username))
                return user;
        }
        return null;
    }

    public Comment getComment(Task targetTask, String content) {
        for (Section section : projectList.currentProject.sections) {
            for (Task task : section.tasks) {
                if (task.title.equals(targetTask.title)) {
                    for (Comment comment : task.comments) {
                        if (comment.content.equals(content))
                            return comment;
                    }
                }
            }
        }

        return null;
    }
}
