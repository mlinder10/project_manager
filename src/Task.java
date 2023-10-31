package src;

/**
 * @author Gavin Orme
 */
import java.util.ArrayList;
import java.util.UUID;

import src.statuses.CreateCommentStatus;
import src.statuses.DeleteCommentStatus;

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

    /**
     * creates getters and setters for the class Task
     * @param title name of the task
     * @param description overview of the task
     * @param priority a 1-3 priority of the task. 1 being the highest and 3 being the lowest
     * @param type type of task which include bug, tester, or new feature
     */
    public Task(String title, String description, int priority, String type) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.type = type;
        this.completion = false;
        this.comments = new ArrayList<Comment>();
        this.changeLog = new ArrayList<Change>();
        this.assignedUsers = new ArrayList<User>();
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

    public CreateCommentStatus createComment(Comment comment) {
        this.comments.add(comment);
        return CreateCommentStatus.SUCCESS;
    }

    public DeleteCommentStatus deleteComment(Comment comment) {
        this.comments.remove(comment);
        return DeleteCommentStatus.SUCCESS;
    }

    public boolean addAssignedUser(User user) {
        assignedUsers.add(user);
        return true;
    }

    public boolean removeAssignedUser(User user) {
        assignedUsers.remove(user);
        return true;
    }
}