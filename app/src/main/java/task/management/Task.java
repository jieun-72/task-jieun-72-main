package task.management;

public class Task implements Comparable<Task> {
    private String taskId;       // 할 일의 고유 ID
    private String description;   // 할 일의 설명
    private boolean isCompleted;   // 할 일의 완료 여부
    private int priority;         // 할 일의 우선순위

    // 생성자
    public Task(String taskId, String description, int priority) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.isCompleted = false; // 기본값 false로 설정
    }

    // 할 일 완료 메서드
    public void completeTask() {
        this.isCompleted = true;
    }

    // 우선순위 설정 메서드
    public void setPriority(int priority) {
        this.priority = priority;
    }

    // Getter 메서드
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

    // Setter 메서드
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // 다른 Task와 비교 메서드
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
