package src.tests;

import src.ProjectFACADE;

public class LoaderTester {
    public static void main(String[] args) {
        ProjectFACADE facade = new ProjectFACADE();
        // boolean log = facade.login("jdoe", "VBefgAf7gf");
        // System.out.println(log);
        // boolean create = facade.createProject("New Project");

        // System.out.println(create);
        facade.register("null", "null", "null");
        boolean save = facade.saveData();
    }
}
