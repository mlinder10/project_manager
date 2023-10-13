package src;
import java.util.ArrayList;

public class Section {
    private String id;
    private String title;
    private ArrayList<Task> tasks;

    public Section(String title){
        this.title = title;
        ArrayList<Task> tasks = new ArrayList<Task>();
    }

    public boolean addTask(Task task){
        return true;
    }

    public boolean removeTask(Task task){
        return true;
    }
}
