package src;

import java.util.Scanner;
public class UI {
    private UserList userList = UserList.getUserList();
    private ProjectList projectList = ProjectList.getProjectList();

    public void signupScenario(){
        System.out.println("email:");
        String email = "CKid87@email.com";
        System.out.println("Username:");
        String username= "CKid87";
        System.out.println("Password:");
        String password = "1234";
        userList.register(username,password,email);
    }

    public void loginScenario(){
        while (true) {
            System.out.println("Username:");
           String username= "CKid87";
            System.out.println("Password:");
            String password = "1234";
            if (userList.login(username, password)) {
                break;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
    }

    public void createProjectScenario(){
      System.out.println("Would you like to create a project? (Yes or No)");
        String pick = "yes";
        switch (pick.toLowerCase()) {
            case "yes":
                System.out.println("Title of Project:");
                String title = "Scrum Board";
                User currentUser = userList.user;
                projectList.createProject(currentUser, title);
                break;
            case "no":
                System.out.println("Project creation canceled.");
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }
}
