package src;
import java.util.ArrayList;

public class Section {
    private String id;
    private String title;
    private ArrayList<Task> tasks;

    public Section(String title, String id){
        this.title = title;
        this.id = id;
        ArrayList<Task> tasks = new ArrayList<Task>();
    }

    public boolean addTask(Task task){
        for (Task sectionElement : tasks)
        {
            if(task.id.equals(sectionElement.id))
                task.users.add(task);
        }
        return true;
    }

    public boolean removeTask(Task task){
        return true;
    }
}
