package task.management;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    private Queue<Task> taskQueue; // 할 일(Task)을 관리하는 큐

    // 생성자
    public TaskQueue() {
        this.taskQueue = new LinkedList<>(); // LinkedList로 초기화
    }

    // 큐에 새로운 할 일 추가 메서드
    public void addTask(Task task) {
        taskQueue.add(task);
    }

    // 큐의 첫 번째 할 일 제거하고 반환 메서드
    public Task removeTask() {
        return taskQueue.poll(); // 큐가 비어있으면 null 반환
    }

    // 큐의 첫 번째 할 일 반환 메서드(제거하지 않음)
    public Task peekTask() {
        return taskQueue.peek(); // 큐가 비어있으면 null 반환
    }

    // 큐가 비어있는지 여부 반환 메서드
    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }

    // 큐에 남아있는 할 일의 수 반환 메서드
    public int size() {
        return taskQueue.size();
    }

    // Getter 메서드
    public Queue<Task> getTaskQueue() {
        return taskQueue; // 큐 반환
    }

    // Setter 메서드 (선택적, 사용되지 않을 수 있음)
    public void setTaskQueue(Queue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }
}
