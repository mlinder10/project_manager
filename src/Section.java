package src;

import java.util.ArrayList;

import src.statuses.CreateTaskStatus;
import src.statuses.DeleteTaskStatus;
/**
 * Section class groups task together
 */
public class Section {
    public String title;
    public ArrayList<Task> tasks;
/**
 * Section constructor for new section. Requires title. Creates array list of tasks
 * @param title
 */
    public Section(String title) {
        this.title = title;
        this.tasks = new ArrayList<Task>();
    }

/**
 * Section constructor for existing section. Requires title and array list of tasks.
 * @param title
 */
    public Section(String title, ArrayList<Task> tasks) {
        this.title = title;
        this.tasks = tasks;
    }

/**
 * adds task to section 
 * @param task
 * @return Success
 */
    public CreateTaskStatus createTask(Task task) {
        this.tasks.add(task);
        return CreateTaskStatus.SUCCESS;
    }

/**
 * Deletes task from section
 * @param task
 * @return Success
 */
    public DeleteTaskStatus deleteTask(Task task) {
        this.tasks.remove(task);
        return DeleteTaskStatus.SUCCESS;
    }
}
