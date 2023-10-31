package src.tests;

import src.ProjectFacade;
import src.statuses.SaveDataStatus;

public class LoaderTester {
    public static void main(String[] args) {
        ProjectFacade facade = new ProjectFacade();
        // boolean log = facade.login("jdoe", "VBefgAf7gf");
        // System.out.println(log);
        // boolean create = facade.createProject("New Project");

        // System.out.println(create);
        facade.register("null", "null", "null");
        SaveDataStatus save = facade.saveData();
    }
}
