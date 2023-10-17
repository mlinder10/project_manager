package src;
/**
 * @author Gavin Orme
 */
import java.util.ArrayList;

 public class Task
 {
    public String id;
    public String description;
    public String title;
    public String type;
    public ArrayList<User> assignedUsers;
    public boolean completion;
    public int priority;
    public String category;
    public ArrayList<Comment> comments;
    public ArrayList<SectionTitle> changeLog;

    public Task(String title, String description, int priority, String category)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
    }

    public boolean addComment(Comment comment)
    {
        return true;
    }
 }