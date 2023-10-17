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
    public String category;
    public ArrayList<Comment> comments;
    public ArrayList<String> changeLog;

    public Task(String title, String description, int priority, String category) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
    }

    public Task(UUID id, String title, String description, String type, ArrayList<User> assignedUsers,
            boolean completion, int priority, String category, ArrayList<Comment> comments,
            ArrayList<String> changeLog) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.assignedUsers = assignedUsers;
        this.completion = completion;
        this.priority = priority;
        this.category = category;
        this.comments = comments;
        this.changeLog = changeLog;
    }

    public boolean addComment(Comment comment) {
        this.comments.add(comment);
        return true;
    }
}