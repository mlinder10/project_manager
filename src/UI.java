package src;

public class UI {
    public void scenario() {
        ProjectFACADE facade = new ProjectFACADE();
        facade.login("atticusmadden", "password");
        Project project = facade.openProject("Electric Missiles");
        Task task = facade.createTask("Todo", "Initialize super algorithm to detonate at warp speed.", "", 1, "New Feature");
        facade.createComment(task, "Avoid civillians Jeff");

        facade.moveTask(null, null, task);
        Section abandoned = facade.createSection("Abandoned");

        facade.moveTask(abandoned, abandoned, task);
    }
}
