package src;

import java.util.ArrayList;
import java.util.Date;

public class Project {
    String id;
    User owner;
    String title;
    Date start;
    Date end;
    ArrayList<Comment> comments;
    ArrayList<User> users;
    ArrayList<Section> sections;
    ArrayList<Change> backlog;

    public Project(String title, User owner, Date startDate, Date endDate){

    }

    public boolean editProject(String title){
        return true;
    }

    public boolean addSection(Section section){
        return true;
    }

    public boolean removeSection(Section section){
        return true;
    }

    public boolean addUser(User user){
        return true;
    }

    public boolean addComent(Comment comment){
        return true;
    }




}
