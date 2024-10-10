package task.management;

public class Task implements Comparable<Task> {
    private String taskId;       
    private String description;   
    private boolean isCompleted;   
    private int priority;         

    
    public Task(String taskId, String description, int priority) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.isCompleted = false;
    }

    
    public void completeTask() {
        this.isCompleted = true;
    }

    
    public void setPriority(int priority) {
        this.priority = priority;
    }

    
    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getPriority() {
        return priority;
    }

   
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
