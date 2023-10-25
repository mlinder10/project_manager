package src;

import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class DataWriter extends DataConstants {

    public static boolean saveUsers(ArrayList<User> users) {
        JSONArray jsonUsers = new JSONArray();
        for (User user : UserList.getUserList().users) {
            jsonUsers.add(getUserJson(user));
        }
        try (FileWriter file = new FileWriter("json/usersTest.json")) {
            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveProjects(ArrayList<Project> projects) {
        JSONArray jsonProject = new JSONArray();
        for (Project project : ProjectList.getProjectList().projects) {
            jsonProject.add(getProjectJson(project));
        }
        try (FileWriter file = new FileWriter("json/projectsTest.json")) {
            file.write(jsonProject.toJSONString());
            file.flush();
            return true;
        } catch (IOException o) {
            o.printStackTrace();
            return false;
        }
    }

    public static JSONObject getUserJson(User user) {
        JSONObject userJson = new JSONObject();
        userJson.put(USER_ID, user.id.toString());
        userJson.put(USER_USERNAME, user.username);
        userJson.put(USER_EMAIL, user.email);
        userJson.put(USER_PASSWORD, user.getPassword());
        return userJson;
    }

    public static JSONObject getProjectJson(Project project) {
        JSONObject projectJson = new JSONObject();
        projectJson.put(PROJECT_ID, project.id.toString());
        projectJson.put(PROJECT_OWNER, getUserJson(project.owner));
        projectJson.put(PROJECT_TITLE, project.title);

        JSONArray commentsJson = new JSONArray();
        for (Comment comment : project.comments) {
            commentsJson.add(getCommentJson(comment));
        }
        projectJson.put(PROJECT_COMMENTS, commentsJson);

        JSONArray usersJson = new JSONArray();
        for (User user : project.users) {
            usersJson.add(getUserJson(user));
        }
        projectJson.put(PROJECT_USERS, usersJson);

        JSONArray sectionsJson = new JSONArray();
        for (Section section : project.sections) {
            sectionsJson.add(getSectionJson(section));
        }
        projectJson.put(PROJECT_SECTIONS, sectionsJson);

        return projectJson;
    }

    public static JSONObject getSectionJson(Section section) {
        JSONObject sectionJson = new JSONObject();
        sectionJson.put(PROJECT_SECTION_TITLE, section.title);

        JSONArray tasks = new JSONArray();
        for (Task task : section.tasks) {
            tasks.add(getTaskJson(task));
        }
        sectionJson.put(PROJECT_SECTION_TASKS, tasks);
        return sectionJson;
    }

    public static JSONObject getTaskJson(Task task) {
        JSONObject taskJson = new JSONObject();
        taskJson.put(PROJECT_TASK_ID, task.id.toString());
        taskJson.put(PROJECT_TASK_TITLE, task.title);
        taskJson.put(PROJECT_TASK_DESCRIPTION, task.description);
        taskJson.put(PROJECT_TASK_TYPE, task.type);
        taskJson.put(PROJECT_TASK_COMPLETION, task.completion);
        taskJson.put(PROJECT_TASK_PRIORITY, task.priority);

        JSONArray commentsJson = new JSONArray();
        for (Comment comment : task.comments) {
            commentsJson.add(getCommentJson(comment));
        }
        taskJson.put(PROJECT_TASK_COMMENTS, commentsJson);

        JSONArray assignedUsersJson = new JSONArray();
        for (User assignedUser : task.assignedUsers) {
            assignedUsersJson.add(getUserJson(assignedUser));
        }
        taskJson.put(PROJECT_TASK_ASSIGNED_USERS, assignedUsersJson);

        JSONArray changesJson = new JSONArray();
        for (Change change : task.changeLog) {
            changesJson.add(getChangeJson(change));
        }
        taskJson.put(PROJECT_TASK_CHANGELOG, changesJson);
        return taskJson;
    }

    public static JSONObject getCommentJson(Comment comment) {
        JSONObject commentJson = new JSONObject();
        commentJson.put(PROJECT_COMMENTS_ID, comment.id.toString());
        commentJson.put(PROJECT_COMMENTS_USER, getUserJson(comment.user));
        commentJson.put(PROJECT_COMMENTS_DATE, comment.date.toString());
        commentJson.put(PROJECT_COMMENTS_CONTENT, comment.content);

        JSONArray commentsJson = new JSONArray();
        for (Comment commentRecursive : comment.comments) {
            commentsJson.add(getCommentJson(commentRecursive));
        }
        commentJson.put(PROJECT_COMMENTS_COMMENTS, commentsJson);
        return commentJson;
    }

    public static JSONObject getChangeJson(Change change) {
        JSONObject changeJson = new JSONObject();
        changeJson.put(PROJECT_CHANGE_ID, change.id.toString());
        changeJson.put(PROJECT_CHANGE_PREVIOUS, change.previousSection);
        changeJson.put(PROJECT_CHANGE_NEXT, change.nextSection);
        changeJson.put(PROJECT_CHANGE_DATE, change.date.toString());
        changeJson.put(PROJECT_CHANGE_USER, getUserJson(change.userEdited));
        return changeJson;
    }
}
