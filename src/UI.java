package src;

public class UI {
    public void scenario() {
        ProjectFACADE facade = new ProjectFACADE();
        facade.login("atticusmadden", "password");
        facade.openProject("Electric Missiles");

        Task taskOne = facade.createTask("Todo", "Initialize super algorithm to detonate at warp speed.", "", 1, "New Feature");
        facade.createComment(taskOne, "Avoid civillians Jeff");

        Task taskTwo = facade.getTask("Curve the metal to make a cylindrical shape");
        facade.moveTask(taskTwo, "Doing");
        taskTwo.removeAssignedUser(facade.getUser());
        taskTwo.addAssignedUser(facade.getUser("jeffgoldblum"));
        Comment comment = facade.getComment(taskTwo, "Not cylindrical enough");
        facade.createComment(comment, "How about you do it Jeff");

        facade.createSection("Abandoned");
        Task taskThree = facade.getTask("Make impossible burger possible");
        facade.moveTask(taskThree, "Abandoned");
    }
}
