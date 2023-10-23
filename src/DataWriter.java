package src;

import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class DataWriter extends DataConstants {

    public static boolean saveUsers(ArrayList<User> users) {
        ArrayList<User> userList = UserList.getUserList().users;
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJson(userList.get(i)));
        }
        try (FileWriter file = new FileWriter("project_manager/json/users.json")) {
            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveProjects(ArrayList<Project> projects) {
        ArrayList<Project> projectList = ProjectList.getProjectList().projects;
        JSONArray jsonProject = new JSONArray();

        for (int i = 0; i < projectList.size(); i++) {
            jsonProject.add(getProjectJson(projectList.get(i)));
        }
        try (FileWriter file = new FileWriter("project_manager/json/projects.json")) {
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
        for (int commentIndex = 0; commentIndex < project.comments.size(); commentIndex++) {
            JSONObject commentJson = getCommentJson(project.comments.get(commentIndex));
            commentsJson.add(commentJson);
        }
        projectJson.put(PROJECT_COMMENTS, commentsJson);

        JSONArray usersJson = new JSONArray();
        for (int userIndex = 0; userIndex < project.users.size(); userIndex++) {
            JSONObject userJson = getUserJson(project.users.get(userIndex));
            usersJson.add(userJson);
        }
        projectJson.put(PROJECT_USERS, usersJson);

        JSONArray sectionsJson = new JSONArray();
        for (int sectionIndex = 0; sectionIndex < project.sections.size(); sectionIndex++) {
            JSONObject sectionJson = getUserJson(project.users.get(sectionIndex));
            sectionsJson.add(sectionJson);
        }
        projectJson.put(PROJECT_SECTIONS, sectionsJson);

        return projectJson;
    }

    public static JSONObject getSectionJson(Section section) {
        JSONObject sectionJson = new JSONObject();
        return sectionJson;
    }

    public static JSONObject getTaskJson(Task task) {
        JSONObject taskJson = new JSONObject();
        return taskJson;
    }

    public static JSONObject getCommentJson(Comment comment) {
        JSONObject commentJson = new JSONObject();
        return commentJson;
    }

    public static JSONObject getChangeJson(Change change) {
        JSONObject changeJson = new JSONObject();
        return changeJson;
    }
}
