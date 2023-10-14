package src;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class DataWritear extends DataConstants {

    public static boolean saveUsers(ArrayList<User> users) {
        boolean hasUser = false;
        User user = User.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        if(!users.contains(user)) {
            hasUser=true;
            for(int i = 0; i<userList.size(); i++){
                jsonUsers.add(getUserJSON(userList.get(i)));
            }
            try(FileWriter file = new FileWriter("project_manager/json/users.json")) {

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

        if(!projects.contains(project)) {
            hasProject=true;
            for(int i = 0; i<projectList.size(); i++){
                jsonProject.add(getProjectJSON(projectList.get(i)));
            }
            try(FileWriter file = new FileWriter("project_manager/json/projects.json")) {
                file.write(jsonProject.toJSONString());
                file.flush();
            } catch (IOException o) {
                o.printStackTrace();
            }
        } 
        return hasProject;      
    }
    public static JSONObject getUserJSON(User user){
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getID().toString());
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
    }
    public static JSONObject getProjectJSON(Project project){
        JSONObject projectDetails = new JSONObject();
        projectDetails.put(PROJECT_ID, project.getProjectID());
        projectDetails.put(PROJECT_OWNER, project.getProjectOwner());
    }
}
