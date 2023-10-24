package src;

import java.util.Date;
import java.util.UUID;

public class Change {

    public UUID id;
    public String previousSection;
    public String nextSection;
    public Date date;
    public User userEdited;

    public Change(String previousSection, String nextSection, User userEdited) {
        this.id = UUID.randomUUID();
        this.previousSection = previousSection;
        this.nextSection = nextSection;
        this.userEdited = userEdited;
        this.date = new Date();
    }

    public Change(UUID id, String previousSection, String nextSection, Date date, User userEdited) {
        this.id = id;
        this.previousSection = previousSection;
        this.nextSection = nextSection;
        this.date = date;
        this.userEdited = userEdited;
    }
}
