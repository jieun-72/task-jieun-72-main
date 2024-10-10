package task.management;

import java.util.Stack;

public class TaskStack {
    private Stack<Task> taskStack; // 할 일(Task)을 관리하는 스택

    // 생성자
    public TaskStack() {
        this.taskStack = new Stack<>(); // Stack으로 초기화
    }

    // 스택에 새로운 할 일 추가 메서드
    public void pushTask(Task task) {
        taskStack.push(task);
    }

    // 스택의 최상단에 있는 할 일 제거하고 반환 메서드
    public Task popTask() {
        return taskStack.isEmpty() ? null : taskStack.pop(); // 스택이 비어있으면 null 반환
    }

    // 스택의 최상단에 있는 할 일 반환 메서드(제거하지 않음)
    public Task peekTask() {
        return taskStack.isEmpty() ? null : taskStack.peek(); // 스택이 비어있으면 null 반환
    }

    // 스택이 비어있는지 여부 반환 메서드
    public boolean isEmpty() {
        return taskStack.isEmpty();
    }

    // 스택에 남아있는 할 일의 수 반환 메서드
    public int size() {
        return taskStack.size();
    }

    // Getter 메서드
    public Stack<Task> getTaskStack() {
        return taskStack; // 스택 반환
    }

    // Setter 메서드 (선택적, 사용되지 않을 수 있음)
    public void setTaskStack(Stack<Task> taskStack) {
        this.taskStack = taskStack;
    }
}
