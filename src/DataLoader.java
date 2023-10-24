package src;

import java.util.UUID;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    public static ArrayList<User> loadUsers() {
        try {
            ArrayList<User> users = new ArrayList<User>();
            FileReader reader = new FileReader("project_manager/json/users.json");
            JSONArray usersJson = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < usersJson.size(); i++) {
                JSONObject userJson = (JSONObject) usersJson.get(i);
                users.add(parseUser(userJson));
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Project> loadProjects() {
        try {
            ArrayList<Project> projects = new ArrayList<Project>();
            FileReader reader = new FileReader("project_manager/json/users.json");
            JSONArray projectsJson = (JSONArray) new JSONParser().parse(reader);

            for (int projectIndex = 0; projectIndex < projectsJson.size(); projectIndex++) {
                // root project parsing
                JSONObject projectJson = (JSONObject) projectsJson.get(projectIndex);
                UUID id = UUID.fromString((String) projectJson.get(PROJECT_ID));
                JSONObject projectOwnerJson = (JSONObject) projectJson.get(PROJECT_OWNER);
                User projectOwner = parseUser(projectOwnerJson);
                String title = (String) projectJson.get(PROJECT_TITLE);

                // sections parsing
                JSONArray sectionsJson = (JSONArray) projectJson.get(PROJECT_SECTIONS);
                ArrayList<Section> sections = new ArrayList<Section>();
                for (int sectionIndex = 0; sectionIndex < sectionsJson.size(); sectionIndex++) {
                    JSONObject sectionJson = (JSONObject) projectJson.get(sectionIndex);
                    UUID sectionId = UUID.fromString((String) sectionJson.get(PROJECT_SECTION_ID));
                    String sectionTitle = (String) sectionJson.get(PROJECT_SECTION_TITLE);

                    // tasks parsing
                    JSONArray tasksJson = (JSONArray) sectionJson.get(PROJECT_SECTION_TASKS);
                    ArrayList<Task> tasks = new ArrayList<Task>();
                    for (int taskIndex = 0; taskIndex < tasksJson.size(); taskIndex++) {
                        JSONObject taskJson = (JSONObject) tasksJson.get(taskIndex);
                        UUID taskId = UUID.fromString((String) taskJson.get(PROJECT_TASK_ID));
                        String taskTitle = (String) taskJson.get(PROJECT_TASK_TITLE);
                        String taskDescription = (String) taskJson.get(PROJECT_TASK_DESCRIPTION);
                        String taskType = (String) taskJson.get(PROJECT_TASK_TYPE);
                        boolean completion = (boolean) taskJson.get(PROJECT_TASK_COMPLETION);
                        int priority = (int) taskJson.get(PROJECT_TASK_PRIORITY);

                        // assigned user parsing
                        JSONArray assignedUsersJson = (JSONArray) taskJson.get(PROJECT_TASK_ASSIGNED_USERS);
                        ArrayList<User> assignedUsers = new ArrayList<User>();
                        for (int assignedUserIndex = 0; assignedUserIndex < assignedUsersJson
                                .size(); assignedUserIndex++) {
                            JSONObject assignedUserJson = (JSONObject) assignedUsersJson.get(assignedUserIndex);
                            assignedUsers.add(parseUser(assignedUserJson));
                        }

                        // comment parsing
                        JSONArray taskCommentsjson = (JSONArray) projectJson.get(PROJECT_TASK_COMMENTS);
                        ArrayList<Comment> taskComments = new ArrayList<Comment>();
                        for (int commentIndex = 0; commentIndex < taskCommentsjson.size(); commentIndex++) {
                            JSONObject commentJsonRecursive = (JSONObject) taskCommentsjson.get(commentIndex);
                            taskComments.add(parseComment(commentJsonRecursive));
                        }

                        // changelog parsing
                        JSONArray changeLogJson = (JSONArray) taskJson.get(PROJECT_TASK_CHANGELOG);
                        ArrayList<Change> changeLog = new ArrayList<Change>();
                        for (int changeIndex = 0; changeIndex < changeLogJson.size(); changeIndex++) {
                            JSONObject changeJson = (JSONObject) changeLogJson.get(changeIndex);
                            UUID changeId = UUID.fromString((String)changeJson.get(PROJECT_CHANGE_ID));
                            String previousSection = (String)changeJson.get(PROJECT_CHANGE_PREVIOUS);
                            String nextSection = (String)changeJson.get(PROJECT_CHANGE_NEXT);
                            Date changeDate = (Date)changeJson.get(PROJECT_CHANGE_DATE);
                            JSONObject userJson = (JSONObject)changeJson.get(PROJECT_CHANGE_USER);
                            User userEdited = parseUser(userJson);
                            changeLog.add(new Change(changeId, previousSection, nextSection, changeDate, userEdited));
                        }
                        tasks.add(new Task(taskId, taskTitle, taskDescription, taskType, assignedUsers, completion,
                                priority, taskComments, changeLog));
                    }
                    sections.add(new Section(sectionId, sectionTitle, tasks));
                }

                // user parsing
                JSONArray usersJson = (JSONArray) projectJson.get(PROJECT_USERS);
                ArrayList<User> users = new ArrayList<User>();
                for (int userIndex = 0; userIndex < usersJson.size(); userIndex++) {
                    JSONObject userJson = (JSONObject) usersJson.get(userIndex);
                    users.add(parseUser(userJson));
                }

                // comment parsing
                JSONArray commentsJson = (JSONArray) projectJson.get(PROJECT_COMMENTS);
                ArrayList<Comment> comments = new ArrayList<Comment>();
                for (int commentIndex = 0; commentIndex < commentsJson.size(); commentIndex++) {
                    JSONObject commentJsonRecursive = (JSONObject) commentsJson.get(commentIndex);
                    comments.add(parseComment(commentJsonRecursive));
                }

                projects.add(new Project(id, title, projectOwner, comments, users,
                        sections));
            }
            return projects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static User parseUser(JSONObject userJson) {
        UUID id = UUID.fromString((String) userJson.get(USER_ID));
        String username = (String) userJson.get(USER_USERNAME);
        String password = (String) userJson.get(USER_PASSWORD);
        String email = (String) userJson.get(USER_EMAIL);
        return new User(id, username, password, email);
    }

    private static Comment parseComment(JSONObject commentJson) {
        UUID id = UUID.fromString((String) commentJson.get(PROJECT_COMMENTS_ID));
        String content = (String) commentJson.get(PROJECT_COMMENTS_CONTENT);
        Date date = (Date) commentJson.get(PROJECT_COMMENTS_DATE);
        User user = parseUser((JSONObject) commentJson.get(PROJECT_COMMENTS_USER));

        // recursively parsing comments
        JSONArray commentsJson = (JSONArray) commentJson.get(PROJECT_COMMENTS_COMMENTS);
        ArrayList<Comment> comments = new ArrayList<Comment>();
        for (int commentIndex = 0; commentIndex < commentsJson.size(); commentIndex++) {
            JSONObject commentJsonRecursive = (JSONObject) commentsJson.get(commentIndex);
            comments.add(parseComment(commentJsonRecursive));
        }
        return new Comment(id, content, user, comments, date);
    }
}