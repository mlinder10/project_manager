package src;

/**
 * @author Gavin Orme
 */
import java.util.ArrayList;
import java.util.Date;
public class Comment 
{
    private User user;
    private ArrayList<Comment> comments;
    public Date date;
    public String content;
    public String id;

    public Comment(String title, String description)
    {
        // this.user = user;
        // this.content = content;
        // this.id = id;
        // this.date = date;
    }

    public boolean addComment(Comment comment)
    {
        return true;
    }
   
}