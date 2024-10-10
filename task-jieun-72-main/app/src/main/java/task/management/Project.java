package task.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private String projectId;                          // 프로젝트의 고유 ID
    private String title;                               // 프로젝트의 제목
    private List<User> userList;                       // 프로젝트에 포함된 사용자 목록
    private Map<String, ArrayList<Task>> taskMap;     // 사용자 ID를 키로 하는 할 일 목록

    // 생성자
    public Project(String projectId, String title) {
        this.projectId = projectId;
        this.title = title;
        this.userList = new ArrayList<>();             // 빈 리스트로 초기화
        this.taskMap = new HashMap<>();                 // 빈 맵으로 초기화
    }

    // 사용자 추가 메서드
    public void addUser(User user) {
        userList.add(user);
        taskMap.put(user.getUserId(), new ArrayList<>()); // 사용자 ID로 빈 할 일 목록 초기화
    }

    // 사용자 제거 메서드
    public void removeUser(String userId) {
        userList.removeIf(user -> user.getUserId().equals(userId));
        taskMap.remove(userId); // 해당 사용자 ID의 할 일 목록도 제거
    }

    // 특정 사용자에게 할 일 할당 메서드
    public void assignTaskToUser(String userId, Task task) {
        if (taskMap.containsKey(userId)) {
            taskMap.get(userId).add(task); // 해당 사용자에게 할 일 추가
        }
    }

    // 특정 사용자가 소유한 할 일 목록 반환 메서드
    public List<Task> getUserTasks(String userId) {
        return taskMap.getOrDefault(userId, new ArrayList<>()); // 사용자 ID에 해당하는 할 일 목록 반환
    }


    // 프로젝트에 포함된 모든 사용자 목록 반환 메서드
    public List<User> getUserList() {
        return userList; // 사용자 목록 반환
    }

    // Getter 메서드
    public String getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    // Setter 메서드
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
