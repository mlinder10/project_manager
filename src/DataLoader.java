package src;
import java.util.UUID;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class DataLoader {
    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try{
            FileReader reader = new FileReader("project_manager/json/users.json");
            JSONParser parser = new JSONParser();
            JSONArray dudesJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < dudesJSON.size(); i++)
            {
                JSONObject dudeJSON = (JSONObject)dudesJSON.get(i);
                UUID id = UUID.fromString((String)dudeJSON.get(USER_ID));
                String userName = (String)dudeJSON.get(USER_USERNAME);
                String passWord = (String)dudeJSON.get(USER_PASSWORD);
                String email = (String)dudeJSON.get(USER_EMAIL);

                users.add(new User(id, userName, passWord, email));

            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }

    public static ArrayList<Project> loadProjects() {

        ArrayList<Project> projects = new ArrayList<Project>();
         try{
            FileReader reader = new FileReader("project_manager/json/users.json");
            JSONParser parser = new JSONParser();
            JSONArray itemsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < itemsJSON.size(); i++)
            {
                JSONObject itemJSON = (JSONObject)itemsJSON.get(i);
                UUID id = UUID.fromString((String)itemJSON.get(USER_ID));
                String projectOwner = (String)itemJSON.get(USER_USERNAME);
                projects.add(new Project(id, projectOwner));

            }
            return projects;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}