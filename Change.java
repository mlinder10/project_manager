import java.sql.Date;

public class Change {
    
    public String id;
    public Task task;
    public String previousSection;
    public String nextSection;
    public Date date;
    public User userEdited;

    public Change(Task task, String previousSection, String nextSection, User userEdited) {

    }
}
