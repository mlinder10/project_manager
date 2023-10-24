package src;

import java.util.ArrayList;
import java.util.UUID;

public class Section {

    public UUID id;
    public String title;
    public ArrayList<Task> tasks;

    public Section(String title) {
        this.title = title;
        this.tasks = new ArrayList<Task>();
    }

    public Section(UUID id, String title, ArrayList<Task> tasks) {
        this.id = id;
        this.title = title;
        this.tasks = tasks;
    }

    public boolean addTask(Task task) {
        this.tasks.add(task);
        return true;
    }

    public boolean removeTask(Task task) {
        this.tasks.remove(task);
        return true;
    }
}
