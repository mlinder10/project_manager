package src;

import java.util.ArrayList;

public class Section {

    public String id;
    public String title;
    private ArrayList<Task> tasks;

    public Section(String title) {
        this.title = title;
        this.tasks = new ArrayList<Task>();
    }

    public Section(String title, ArrayList<Task> tasks) {
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
