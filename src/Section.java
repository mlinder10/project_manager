package src;

import java.util.ArrayList;

public class Section {

    public String title;
    public ArrayList<Task> tasks;

    public Section(String title) {
        this.title = title;
        this.tasks = new ArrayList<Task>();
    }

    public Section(String title, ArrayList<Task> tasks) {
        this.title = title;
        this.tasks = tasks;
    }

    public boolean createTask(Task task) {
        if(this.tasks.add(task))
            return true;
        else  
            return false;
    }

    public boolean removeTask(Task task) {
        if(this.tasks.remove(task))
            return true;
        else 
            return false;
    }
}
