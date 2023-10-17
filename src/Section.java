package src;

import java.util.ArrayList;
import java.util.UUID;

public class Section {
    private UUID id;
    private String title;
    private ArrayList<Task> tasks;

    public Section(String title) {
        this.title = title;
        this.id = UUID.randomUUID();
        this.tasks = new ArrayList<Task>();
    }

    public Section(String title, UUID id, ArrayList<Task> tasks) {
        this.title = title;
        this.id = id;
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
