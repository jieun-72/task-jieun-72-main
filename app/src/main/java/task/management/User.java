package task.management;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;                 
    private String name;                   
    private List<Task> taskList;          

 
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.taskList = new ArrayList<>();  
    }

    
    public void addTask(Task task) {
        taskList.add(task);
    }

  
    public void removeTask(String taskId) {
        taskList.removeIf(task -> task.getTaskId().equals(taskId));
    }

    
    public Task getTaskById(String taskId) {
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                return task; 
            }
        }
        return null; 
    }

  
    public List<Task> getTaskList() {
        return taskList; 
    }

   
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
