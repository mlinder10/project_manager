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

    public Comment(String content, User user) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.content = content;
        this.date = new Date();
        this.comments = new ArrayList<Comment>();
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