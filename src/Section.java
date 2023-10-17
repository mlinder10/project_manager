package src;

import java.util.ArrayList;

public class Section {
    public String title;
    private ArrayList<Task> tasks;

<<<<<<< HEAD
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
=======
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
>>>>>>> 9c2772e9a2a036a41693f5525831e8685191c05d
        return true;
    }
}
