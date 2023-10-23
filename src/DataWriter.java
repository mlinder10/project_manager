package src;

import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class DataWriter extends DataConstants {

    public static boolean saveUsers(ArrayList<User> users) {
        boolean hasUser = false;
        User user = User.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        if (!users.contains(user)) {
            hasUser = true;
            for (int i = 0; i < userList.size(); i++) {
                jsonUsers.add(getUserJSON(userList.get(i)));
            }
            try (FileWriter file = new FileWriter("project_manager/json/users.json")) {

                file.write(jsonUsers.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hasUser;
    }

    public static boolean saveProjects(ArrayList<Project> projects) {
        boolean hasProject = false;
        Project project = Project.getInstance();
        ArrayList<Project> projectList = projects.getProjects();
        JSONArray jsonProject = new JSONArray();

        if (!projects.contains(project)) {
            hasProject = true;
            for (int i = 0; i < projectList.size(); i++) {
                jsonProject.add(getProjectJSON(projectList.get(i)));
            }
            try (FileWriter file = new FileWriter("project_manager/json/projects.json")) {
                file.write(jsonProject.toJSONString());
                file.flush();
            } catch (IOException o) {
                o.printStackTrace();
            }
        }
        return hasProject;
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getID().toString());
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
    }

    public static JSONObject getProjectJSON(Project project) {
        JSONObject projectDetails = new JSONObject();
        projectDetails.put(PROJECT_ID, project.getProjectID());
        projectDetails.put(PROJECT_TITLE, project.getTitle());
        projectDetails.put(PROJECT_START, project.getStart());
        projectDetails.put(PROJECT_END, project.getEnd());
        projectDetails.put(PROJECT_SECTIONS, project.getSections());
        projectDetails.put(PROJECT_SECTIONS_ID, project.getSectionID().toString());
        projectDetails.put(PROJECT_SECTIONS_TITLE, project.getSectionTitle());
        projectDetails.put(PROJECT_SECTIONS_DESCRIPTION, project.getDescription());
        projectDetails.put(PROJECT_SECTIONS_TYPE, project.getType());
        projectDetails.put(PROJECT_SECTIONS_ASSIGNED_USERS, project.getAssignedUsers());
        projectDetails.put(PROJECT_SECTIONS_COMPLETION, project.getCompletion());
        projectDetails.put(PROJECT_SECTIONS_PRIORITY, project.getPriority());
        projectDetails.put(PROJECT_SECTIONS_CATEGORY, project.getCategory());
        projectDetails.put(PROJECT_SECTIONS_COMMENTS, project.getSectionComments());
        projectDetails.put(PROJECT_SECTIONS_COMMENTS_ID, project.getSectionCommentsID());
        projectDetails.put(PROJECT_SECTIONS_COMMENTS_CONTENT, project.getSectionCommentContent());
        projectDetails.put(PROJECT_SECTIONS_COMMENTS_DATE, project.getSectionCommentDate());
        projectDetails.put(PROJECT_SECTIONS_COMMENTS_USER, project.getSectionCommentUser());
        projectDetails.put(PROJECT_SECTIONS_COMMENTS_COMMENTS, project.getSectionCommentsComment());
        projectDetails.put(PROJECT_SECTIONS_CHANGELOG, project.getSectionChange());
        projectDetails.put(PROJECT_USERS, project.getProjectUser());
        projectDetails.put(PROJECT_COMMENTS, project.getProjectComments());
        projectDetails.put(PROJECT_COMMENTS_ID, project.getProjectCommentsID());
        projectDetails.put(PROJECT_COMMENTS_CONTENT, project.getProjectContent());
        projectDetails.put(PROJECT_COMMENTS_DATE, project.getProjectCommentDate());
        projectDetails.put(PROJECT_COMMENTS_COMMENTS, project.getProjectCommentsComments());
        projectDetails.put(PROJECT_COMMENTS_USER, project.getProjectCommentUser());
        projectDetails.put(PROJECT_BACKLOG, project.getProjectBacklog());
        projectDetails.put(PROJECT_BACKLOG_ID, project.getBacklogID());
        projectDetails.put(PROJECT_BACKLOG_TASK, project.getBacklogasks());
        projectDetails.put(PROJECT_BACKLOG_PREVIOUS_SECTION, project.getBacklogPrev());
        projectDetails.put(PROJECT_BACKLOG_NEXT_SECTION, project.getBacklogNextSection());
        projectDetails.put(PROJECT_BACKLOG_DATE, project.getBacklogDate());
        projectDetails.put(PROJECT_BACKLOG_USER_EDITED, project.getBacklogEdits());
    }
}
