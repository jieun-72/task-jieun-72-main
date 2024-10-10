package task.management;

import java.util.Stack;

public class TaskStack {
    private Stack<Task> taskStack;

   
    public TaskStack() {
        this.taskStack = new Stack<>();
    }

    
    public void pushTask(Task task) {
        taskStack.push(task);
    }

    
    public Task popTask() {
        return taskStack.isEmpty() ? null : taskStack.pop(); 
    }

    
    public Task peekTask() {
        return taskStack.isEmpty() ? null : taskStack.peek();
    }

   
    public boolean isEmpty() {
        return taskStack.isEmpty();
    }

   
    public int size() {
        return taskStack.size();
    }

   
    public Stack<Task> getTaskStack() {
        return taskStack; 
    }

 
    public void setTaskStack(Stack<Task> taskStack) {
        this.taskStack = taskStack;
    }
}
