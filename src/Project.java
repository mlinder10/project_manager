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

    public Project(String title, User owner) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.title = title;
        this.comments = new ArrayList<Comment>();
        this.users = new ArrayList<User>();
        this.sections = new ArrayList<Section>();
    }

    public Project(UUID id, String title, User owner, ArrayList<Comment> comments, ArrayList<User> users,
            ArrayList<Section> sections) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.comments = comments;
        this.users = users;
        this.sections = sections;
    }

    public boolean editProjectTitle(String title) {
        this.title = title;
        return true;
    }

    public boolean addSection(Section section) {
        this.sections.add(section);
        return true;
    }

    public boolean removeSection(Section section) {
        this.sections.remove(section);
        return true;
    }

    public boolean addUser(User user) {
        this.users.add(user);
        return true;
    }

    public boolean addComent(Comment comment) {
        this.comments.add(comment);
        return true;
    }
}
