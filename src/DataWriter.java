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
