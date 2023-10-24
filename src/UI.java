package src;

public class UI {
    public static void main(String[] args) {
        scenarioOne();
    }

    public static void scenarioOne() {
        ProjectFACADE facade = new ProjectFACADE();
        facade.login("jdoe", "VBefgAf7gf");
        facade.createProject("New Project");
        facade.saveData();
    }

    public static void scenarioTwo() {

    }

    public static void scenarioThree() {

    }
}
