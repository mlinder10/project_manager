package src;

public class UI {
    public void scenario() {
        ProjectFACADE facade = new ProjectFACADE();
        facade.login("atticusmadden", "password");
        Project project = facade.openProject("Electric Missiles");

    }
}
