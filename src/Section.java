package src;
import java.util.ArrayList;

public class Section {
    private String id;
    private String title;
    private ArrayList<Task> tasks;

    public Section sectionTitle(String title){
        this.title = title;
        this.id = id;
        ArrayList<Task> tasks = new ArrayList<Task>();
        return sectionTitle(title);
    }

    public boolean addTask(Task task){
        Task newTask = new Task(title, description, 0, category);
        return true;
    }

    public boolean removeTask(Task task){
        tasks.remove(task);
        return true;
    }
}
