package src;

/**
 * @author Gavin Orme
 */
import java.util.ArrayList;
import java.util.UUID;

public class Task {

    public UUID id;
    public String description;
    public String title;
    public String type;
    public ArrayList<User> assignedUsers;
    public boolean completion;
    public int priority;
    public ArrayList<Comment> comments;
    public ArrayList<Change> changeLog;

    public Task(String title, String description, int priority, String type) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.type = type;
        this.comments = new ArrayList<Comment>();
        this.changeLog = new ArrayList<Change>();
    }

    public Task(UUID id, String title, String description, String type, ArrayList<User> assignedUsers,
            boolean completion, int priority, ArrayList<Comment> comments,
            ArrayList<Change> changeLog) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.assignedUsers = assignedUsers;
        this.completion = completion;
        this.priority = priority;
        this.comments = comments;
        this.changeLog = changeLog;
    }

    public boolean addComment(Comment comment) {
        if(this.comments.add(comment))
            return true;
        else 
            return false;
    }
}