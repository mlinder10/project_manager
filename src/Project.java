package src;

import java.util.ArrayList;
import java.util.UUID;

public class Project {
    UUID id;
    User owner;
    String title;
    ArrayList<Comment> comments;
    ArrayList<User> users;
    ArrayList<Section> sections;
    ArrayList<Change> backlog;

    public Project(String title, User owner){

    }
    public Project(UUID id, String title, User owner){
        
    }

    public Project(UUID id, String title, User owner) {

    }

    public boolean editProject(String title) {
        return true;
    }

    public boolean addSection(Section section) {
        return true;
    }

    public boolean removeSection(Section section) {
        return true;
    }

    public boolean addUser(User user) {
        return true;
    }

    public boolean addComent(Comment comment) {
        return true;
    }

}
