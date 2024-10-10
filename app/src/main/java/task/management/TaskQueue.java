package task.management;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    private Queue<Task> taskQueue; 

    
    public TaskQueue() {
        this.taskQueue = new LinkedList<>(); 
    }

    
    public void addTask(Task task) {
        taskQueue.add(task);
    }

    
    public Task removeTask() {
        return taskQueue.poll(); 
    }

    
    public Task peekTask() {
        return taskQueue.peek();
    }

    
    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }

    
    public int size() {
        return taskQueue.size();
    }

    
    public Queue<Task> getTaskQueue() {
        return taskQueue; 
    }

    
    public void setTaskQueue(Queue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }
}
