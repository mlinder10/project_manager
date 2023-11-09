package src.tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import src.ProjectFACADE;
import src.Project;
import src.Section;
import src.Task;
import src.User;
import src.Comment;
import src.statuses.LoginStatus;
import src.statuses.RegisterStatus;
import src.statuses.SaveDataStatus;
import src.statuses.LogoutStatus;
import src.statuses.DeleteProjectStatus;
import src.statuses.CreateCommentStatus;
import src.statuses.DeleteCommentStatus;
import src.statuses.DeleteSectionStatus;
import src.statuses.DeleteTaskStatus;
import src.statuses.CreateProjectStatus;
import src.statuses.MoveTaskStatus;
import src.statuses.AddUserStatus;

public class ProjectFACADETest {

    private ProjectFACADE facade;

    @Before
    public void setUp() {
        facade = new ProjectFACADE();
    }

// Test cases for login method
    @Test
    public void testLoginValidUser() {
        facade.register("validUsername", "validPassword", "test@example.com");
        LoginStatus status = facade.login("validUsername", "validPassword");
        assertEquals(LoginStatus.SUCCESS, status);
    }

    @Test
    public void testLoginInvalidUser() {
        LoginStatus status = facade.login("invalidUsername", "invalidPassword");
        assertEquals(LoginStatus.INVALID_CREDENTIALS, status);
    }

// Test cases for register method
    @Test
    public void testRegisterValidUser() {
        RegisterStatus status = facade.register("newUser", "newPassword", "test@example.com");
        assertEquals(RegisterStatus.SUCCESS, status);
    }

    @Test
    public void testRegisterEmptyUsernameAndPasswordAndEmail() {
        RegisterStatus status = facade.register("", "", "");
        assertEquals(RegisterStatus.EMPTY_USERNAME_AND_PASSWORD_AND_EMAIL, status);
    }

    @Test
    public void testRegisterEmptyUsernameAndPassword() {
        RegisterStatus status = facade.register("", "", "test@example.com");
        assertEquals(RegisterStatus.EMPTY_USERNAME_AND_PASSWORD, status);
    }

    @Test
    public void testRegisterEmptyUsernameAndEmail() {
        RegisterStatus status = facade.register("", "newPassword", "");
        assertEquals(RegisterStatus.EMPTY_USERNAME_AND_EMAIL, status);
    }

    @Test
    public void testRegisterEmptyEmailAndPassword() {
        RegisterStatus status = facade.register("newUser", "", "");
        assertEquals(RegisterStatus.EMPTY_PASSWORD_AND_EMAIL, status);
    }

    @Test
    public void testRegisterEmptyUsername() {
        RegisterStatus status = facade.register("", "newPassword", "test@example.com");
        assertEquals(RegisterStatus.EMPTY_USERNAME, status);
    }

    @Test
    public void testRegisterEmptyPassword() {
        RegisterStatus status = facade.register("newUser", "", "test@exaple.com");
        assertEquals(RegisterStatus.EMPTY_PASSWORD, status);
    }

    @Test
    public void testRegisterEmptyEmail() {
        RegisterStatus status = facade.register("newUser", "newPassword", "");
        assertEquals(RegisterStatus.EMPTY_EMAIL, status);
    }

    @Test
    public void testRegisterUsernameTaken() {
        facade.register("newUser", "newPassword", "test@example.com");
        RegisterStatus status = facade.register("newUser", "newPassword", "test@example.com");
        assertEquals(RegisterStatus.USERNAME_TAKEN, status);
    }

// Test cases for logout method
    @Test
    public void testLogout() {
        LogoutStatus status = facade.logout();
        assertEquals(LogoutStatus.SUCCESS, status);
    }

// Test cases for createProject method
    @Test
    public void testCreateProject() {
        CreateProjectStatus status = facade.createProject("New Project");
        assertEquals(CreateProjectStatus.SUCCESS, status);
    }

// Test cases for deleteProject method
    @Test
    public void testDeleteProject() {
        Project projectToDelete = new Project("newProject", null); 
        DeleteProjectStatus status = facade.deleteProject(projectToDelete);

        assertEquals(DeleteProjectStatus.SUCCESS, status);
}

//Test cases for getSection
    @Test
    public void testGetSectionExistingSection() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = new Section("newSection");
        Section retrievedSection = facade.getSection("newSection");
        assertNotNull(retrievedSection);
        assertEquals(section, retrievedSection);
}

    @Test
    public void testGetSectionNonExistentSection() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section retrievedSection = facade.getSection("NonExistentSection");
        assertNull(retrievedSection);
    }

// Test cases for deleteSection method
    @Test
    public void testDeleteSection() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section sectionToDelete = facade.createSection("SectionToDelete");
        DeleteSectionStatus status = facade.deleteSection(facade.getCurrentProject(), sectionToDelete);
        assertEquals(DeleteSectionStatus.SUCCESS, status);
    }

// Test cases for createTask method
    @Test
    public void testCreateTaskInSection() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("Test Section");
        Task task = facade.createTask(section, "Task 1", "Description", 1, "Type");
        assertNotNull(task);
    }

    @Test
    public void testCreateTaskInSectionByTitle() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("Test Section");
        Task task = facade.createTask("Test Section", "Task 1", "Description", 1, "Type");
        assertNotNull(task);
    }

// Test cases for moveTask method
    @Test
    public void testMoveTask() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section fromSection = facade.createSection("From Section");
        Section toSection = facade.createSection("To Section");
        Task taskToMove = facade.createTask(fromSection, "Task to Move", "Description", 1, "Type");

        boolean result = facade.moveTask("Task to Move", "To Section");
        assertTrue(result);
    }

// Test cases for deleteTask method
    @Test
    public void testDeleteTask() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("Test Section");
        Task taskToDelete = facade.createTask(section, "TaskToDelete", "Description", 1, "Type");
        DeleteTaskStatus status = facade.deleteTask(section, taskToDelete);
        assertEquals(DeleteTaskStatus.SUCCESS, status);
    }

// Test cases for moveTask (overloaded) method
    @Test
    public void testMoveTaskWithinSections() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section fromSection = facade.createSection("From Section");
        Section toSection = facade.createSection("To Section");
        Task taskToMove = facade.createTask(fromSection, "Task to Move", "Description", 1, "Type");

        MoveTaskStatus status = facade.moveTask(fromSection, toSection, taskToMove);
        assertEquals(MoveTaskStatus.SUCCESS, status);
    }

// Test cases for createComment method
    @Test
    public void testCreateCommentOnProject() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        User user = facade.getUser();
        CreateCommentStatus status = facade.createComment(facade.getCurrentProject(), "Comment on project", user);
        assertEquals(CreateCommentStatus.SUCCESS, status);
}

    @Test
    public void testCreateCommentOnTask() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("SectionWithComments");
        Task task = facade.createTask(section, "TaskWithComments", "Description", 1, "Type");
        CreateCommentStatus status = facade.createComment(task, "Comment on task");
        assertEquals(CreateCommentStatus.SUCCESS, status);
    }

// Test cases for deleteComment method
    @Test
    public void testDeleteCommentOnProject() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        User user = facade.getUser();
        CreateCommentStatus createStatus = facade.createComment(facade.getCurrentProject(), "Comment to delete", user);
        DeleteCommentStatus deleteStatus = facade.deleteComment(facade.getCurrentProject(), facade.getCurrentProject().comments.get(0));
        assertEquals(DeleteCommentStatus.SUCCESS, deleteStatus);
    }

    @Test
    public void testDeleteCommentOnTask() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("SectionWithComments");
        Task task = facade.createTask(section, "TaskWithComments", "Description", 1, "Type");
        CreateCommentStatus createStatus = facade.createComment(task, "Comment to delete");
        DeleteCommentStatus deleteStatus = facade.deleteComment(task, task.comments.get(0));
        assertEquals(DeleteCommentStatus.SUCCESS, deleteStatus);
    }

// Test cases for addUserToProject method
    @Test
    public void testAddUserToProject() {
        User user = facade.getUser();
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        AddUserStatus status = facade.addUserToProject(user, facade.getCurrentProject());
        assertEquals(AddUserStatus.SUCCESS, status);
    }

// Test cases for addAssignedUser method
    @Test
    public void testAddAssignedUser() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("SectionWithTask");
        Task task = facade.createTask(section, "TaskWithAssignedUser", "Description", 1, "Type");
        User user = facade.getUser();
        boolean result = facade.addAssignedUser(task, user);
        assertTrue(result);
    }

// Test cases for removeAssignedUser method
    @Test
    public void testRemoveAssignedUser() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("SectionWithTask");
        Task task = facade.createTask(section, "TaskWithAssignedUser", "Description", 1, "Type");
        User user = facade.getUser();
        facade.addAssignedUser(task, user);
        boolean result = facade.removeAssignedUser(task, user);
        assertTrue(result);
    }

// Test cases for saveData method
    @Test
    public void testSaveData() {
        SaveDataStatus status = facade.saveData();
        assertEquals(SaveDataStatus.SUCCESS, status);
    }

// Test cases for getTask method
    @Test
    public void testGetTaskExistingTask() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("SectionWithTask");
        Task task = facade.createTask(section, "Test Task", "Description", 1, "Type");
        Task retrievedTask = facade.getTask("Test Task");
        assertNotNull(retrievedTask);
        assertEquals(task, retrievedTask);
    }

    @Test
    public void testGetTaskNonExistentTask() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Task retrievedTask = facade.getTask("NonExistentTask");
        assertNull(retrievedTask);
    }

// Test cases for moveTask (overloaded) method
    @Test
    public void testMoveTaskWithTask() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section fromSection = facade.createSection("From Section");
        Section toSection = facade.createSection("To Section");
        Task taskToMove = facade.createTask(fromSection, "Task to Move", "Description", 1, "Type");
        Task movedTask = facade.moveTask(taskToMove, "To Section");
        assertNotNull(movedTask);
        assertTrue(toSection.tasks.contains(movedTask));
    }

// Test cases for getUser method
    @Test
    public void testGetUser() {
        facade.login("newUser", "newPassword");
        User user = facade.getUser();
        assertNotNull(user);
    }

    @Test
    public void testGetUserByUsername() {
        User user = facade.getUser("validUsername");
        assertNotNull(user);
        assertEquals("validUsername", user.username);
    }

    @Test
    public void testGetUserByInvalidUsername() {
        User user = facade.getUser("invalidUsername");
        assertNull(user);
    }

// Test cases for getComment method
    @Test
    public void testGetComment() {
        facade.createProject("Test Project");
        facade.openProject("Test Project");
        Section section = facade.createSection("SectionWithTask");
        Task task = facade.createTask(section, "TaskWithComments", "Description", 1, "Type");
        CreateCommentStatus createStatus = facade.createComment(task, "Test Comment");
        Comment comment = task.comments.get(0);

        Comment retrievedComment = facade.getComment(task, "Test Comment");
        assertNotNull(retrievedComment);
        assertEquals(comment, retrievedComment);
    }
    
}
