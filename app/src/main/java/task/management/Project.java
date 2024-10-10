package task.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private String projectId;                          
    private String title;                               
    private List<User> userList;                       
    private Map<String, ArrayList<Task>> taskMap;     

    
    public Project(String projectId, String title) {
        this.projectId = projectId;
        this.title = title;
        this.userList = new ArrayList<>();             
        this.taskMap = new HashMap<>();                 
    }

    
    public void addUser(User user) {
        userList.add(user);
        taskMap.put(user.getUserId(), new ArrayList<>()); 
    }

    
    public void removeUser(String userId) {
        userList.removeIf(user -> user.getUserId().equals(userId));
        taskMap.remove(userId); 
    }

    
    public void assignTaskToUser(String userId, Task task) {
        if (taskMap.containsKey(userId)) {
            taskMap.get(userId).add(task); 
        }
    }

    
    public List<Task> getUserTasks(String userId) {
        return taskMap.getOrDefault(userId, new ArrayList<>()); 
    }


    
    public List<User> getUserList() {
        return userList;
    }

    
    public String getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
