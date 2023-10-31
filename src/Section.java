package src;

import java.util.ArrayList;

import src.statuses.CreateTaskStatus;
import src.statuses.DeleteTaskStatus;

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

    public CreateTaskStatus createTask(Task task) {
        this.tasks.add(task);
        return CreateTaskStatus.SUCCESS;
    }

    public DeleteTaskStatus deleteTask(Task task) {
        this.tasks.remove(task);
        return DeleteTaskStatus.SUCCESS;
    }
}
