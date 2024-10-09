package task.management;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;                  // 사용자의 고유 ID
    private String name;                     // 사용자의 이름
    private List<Task> taskList;            // 사용자가 가지고 있는 할 일 목록

    // 생성자
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.taskList = new ArrayList<>();  // 빈 리스트로 초기화
    }

    // 할 일 추가 메서드
    public void addTask(Task task) {
        taskList.add(task);
    }

    // 할 일 제거 메서드
    public void removeTask(String taskId) {
        taskList.removeIf(task -> task.getTaskId().equals(taskId));
    }

    // taskId에 해당하는 할 일 반환 메서드
    public Task getTaskById(String taskId) {
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                return task; // 해당하는 할 일 반환
            }
        }
        return null; // 없으면 null 반환
    }

    // 할 일 목록 반환 메서드
    public List<Task> getTaskList() {
        return taskList; // 할 일 목록 반환
    }

    // Getter 메서드
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    // Setter 메서드
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
