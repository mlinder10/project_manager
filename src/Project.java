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

<<<<<<< HEAD
    public Project(String title, User owner) {

=======
    public Project(String title, User owner){

    }
    public Project(UUID id, String title, User owner){
        
>>>>>>> 9581a42b85d16c69d2a347d19cd3ed9452aaf8a8
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
