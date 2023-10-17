package src;

/**
 * @author Gavin Orme
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Comment {
    public UUID id;
    private User user;
    private ArrayList<Comment> comments;
    public Date date;
    public String content;

<<<<<<< HEAD
    public Comment(String content, User user) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.content = content;
        this.date = new Date();
        this.comments = new ArrayList<Comment>();
=======
    public Comment(String title, String description)
    {
        this.user = user;
        this.content = content;
        this.id = id;
        this.date = date;
        this.comments = new ArrayList<>(comments);
>>>>>>> 9c2772e9a2a036a41693f5525831e8685191c05d
    }

    public Comment(UUID id, String content, User user, ArrayList<Comment> comments, Date date) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.date = date;
        this.comments = comments;
    }

    public boolean addComment(Comment comment) {
        this.comments.add(comment);
        return true;
    }
}