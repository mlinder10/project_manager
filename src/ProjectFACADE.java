package src;
public class ProjectFACADE {
    private User user;
    private Project currentProject;

    public User login(String username, String password){
        user = UserList.getCurrentUser();
        return user;
    }

    public User signUp(String username, String password, String email){
        return user;
    }

    public Project getCurrentProject(){
        currentProject = ProjectList.getCurrentProject();
        return currentProject;
    } 

    public boolean createProject(){
        
        return true;
    }

    public boolean addUserToProject(){

        return true;
    }
}
