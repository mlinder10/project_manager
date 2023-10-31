package src;

import java.util.ArrayList;
import java.util.UUID;

import src.statuses.AddUserStatus;
import src.statuses.CreateCommentStatus;
import src.statuses.CreateSectionStatus;
import src.statuses.DeleteCommentStatus;
import src.statuses.DeleteSectionStatus;

public class Project {
    public UUID id;
    public User owner;
    public String title;
    public ArrayList<Comment> comments;
    public ArrayList<User> users;
    public ArrayList<Section> sections;

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

    public CreateSectionStatus createSection(Section section) {
        this.sections.add(section);
        return CreateSectionStatus.SUCCESS;
    }

    public DeleteSectionStatus deleteSection(Section section) {
        this.sections.remove(section);
        return DeleteSectionStatus.SUCCESS;
    }

    public AddUserStatus addUser(User user) {
        this.users.add(user);
        return AddUserStatus.SUCCESS;
    }

    public CreateCommentStatus createComment(Comment comment) {
        this.comments.add(comment);
        return CreateCommentStatus.SUCCESS;
    }

    public DeleteCommentStatus deleteComment(Comment comment) {
        this.comments.remove(comment);
        return DeleteCommentStatus.SUCCESS;
    }
}
