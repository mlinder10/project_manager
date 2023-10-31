package src;

import java.util.ArrayList;
import java.util.UUID;

import src.statuses.AddUserStatus;
import src.statuses.CreateCommentStatus;
import src.statuses.CreateSectionStatus;
import src.statuses.DeleteCommentStatus;
import src.statuses.DeleteSectionStatus;

/**
 * Creates a new project 
 */
public class Project {
    public UUID id;
    public User owner;
    public String title;
    public ArrayList<Comment> comments;
    public ArrayList<User> users;
    public ArrayList<Section> sections;

    /**
     * Creates a new project and adds a user and different array list to the project 
     * @param title holds the title of the project in a string 
     * @param owner holds the owner of the project as a user 
     */
    public Project(String title, User owner) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.title = title;
        this.comments = new ArrayList<Comment>();
        this.users = new ArrayList<User>();
        this.sections = new ArrayList<Section>();
    }

    /**
     * creates a new project 
     * @param id holds the users UUID 
     * @param title holds the title of the project in a string 
     * @param owner holds the owner of the project as a user 
     * @param comments holds the comments to the project in an array list of comments
     * @param users holds the users on the project as an array list of users 
     * @param sections holds the sections in the project as an array list of sections 
     */
    public Project(UUID id, String title, User owner, ArrayList<Comment> comments, ArrayList<User> users,
            ArrayList<Section> sections) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.comments = comments;
        this.users = users;
        this.sections = sections;
    }

    /**
     * Edits the title string that holds the projects title 
     * @param title holds the project title in a string 
     * @return returns true to change the project title 
     */
    public boolean editProjectTitle(String title) {
        this.title = title;
        return true;
    }

    public Section getSection(String title) {
        for (Section section : sections) {
            if (section.title.equals(title)) return section;
        }
        return null;
    }

    public CreateSectionStatus createSection(Section section) {
        this.sections.add(section);
        return CreateSectionStatus.SUCCESS;
    }

    /**
     * Deletes a section from the array list of sections
     * @param section holds sections in an array list of sections 
     * @return returns the succes status when a section is removed 
     */
    public DeleteSectionStatus deleteSection(Section section) {
        this.sections.remove(section);
        return DeleteSectionStatus.SUCCESS;
    }

    /**
     * Adds another user to the project 
     * @param user holds the user in a user object 
     * @return returns the success status when a new user is added 
     */
    public AddUserStatus addUser(User user) {
        this.users.add(user);
        return AddUserStatus.SUCCESS;
    }

    /**
     * Creates a new comment and adds a status to it
     * @param comment holds comments in an array list of comments 
     * @return returns the success status when a new comment is created 
     */
    public CreateCommentStatus createComment(Comment comment) {
        this.comments.add(comment);
        return CreateCommentStatus.SUCCESS;
    }

    /**
     * Deletes a comment by removing a comment from the comment array list 
     * @param comment holds comments in an array list of comments 
     * @return returns the success status when a commment is removed 
     */
    public DeleteCommentStatus deleteComment(Comment comment) {
        this.comments.remove(comment);
        return DeleteCommentStatus.SUCCESS;
    }
}
