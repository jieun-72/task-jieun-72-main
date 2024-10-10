package task.management;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private ArrayList<Project> projects; // 최대 5개의 프로젝트를 저장
    private int projectCount;             // 현재 등록된 프로젝트 수
    private TaskQueue taskQueue;          // 할 일 작업 큐
    private TaskStack taskStack;          // 할 일 작업 스택

    // 생성자
    public TaskManager() {
        this.projects = new ArrayList<>(); // 빈 ArrayList로 초기화
        this.projectCount = 0;              // 프로젝트 수 0으로 설정
        this.taskQueue = new TaskQueue();   // TaskQueue 인스턴스 생성
        this.taskStack = new TaskStack();   // TaskStack 인스턴스 생성
    }

    // 프로젝트 등록 메서드
    public void registerProject(Project project) {
        if (projectCount < 5) {
            projects.add(project);
            projectCount++;
        } else {
            System.out.println("프로젝트를 더 이상 등록할 수 없습니다.");
        }
    }

    // 주어진 projectId에 해당하는 프로젝트 반환 메서드
    public Project getProjectById(String projectId) {
        for (Project project : projects) {
            if (project.getProjectId().equals(projectId)) {
                return project; // 해당 프로젝트 반환
            }
        }
        return null; // 없으면 null 반환
    }

    // 특정 프로젝트의 특정 사용자에게 할 일 할당 메서드
    public void assignTaskToUserInProject(String projectId, String userId, Task task) {
        Project project = getProjectById(projectId);
        if (project != null) {
            project.assignTaskToUser(userId, task);
        }
    }

    // 작업 큐에 새로운 할 일 추가 메서드
    public void enqueueTask(Task task) {
        taskQueue.addTask(task);
    }

    // 큐에서 다음 할 일 가져와 완료 처리 메서드
    public void dequeueTask() {
        Task task = taskQueue.removeTask();
        if (task != null) {
            task.completeTask(); // 할 일 완료 처리
        }
    }

    // 작업 스택에 새로운 할 일 추가 메서드
    public void pushTask(Task task) {
        taskStack.pushTask(task);
    }

    // 작업 스택에서 다음 할 일 가져와 완료 처리 메서드
    public void popTask() {
        Task task = taskStack.popTask();
        if (task != null) {
            task.completeTask(); // 할 일 완료 처리
        }
    }

    // 모든 프로젝트의 정보 출력 메서드
    public void printAllProjectsInfo() {
        for (Project project : projects) {
            System.out.println("Project ID: " + project.getProjectId());
            System.out.println("Title: " + project.getTitle());
            System.out.println("Users: " + project.getUserList().size());

            // 각 사용자별 할 일 목록 출력
            for (User user : project.getUserList()) {
                System.out.println("User ID: " + user.getUserId());
                List<Task> userTasks = project.getUserTasks(user.getUserId());
                System.out.println("Tasks: " + userTasks);
            }

            System.out.println("-----------------------------");
        }
    }

    // 특정 프로젝트의 모든 사용자에 대해 할 일 완료 여부 확인 메서드
    public void checkProjectHealth(String projectId) {
        Project project = getProjectById(projectId);
        if (project != null) {
            for (User user : project.getUserList()) {
                // 해당 사용자의 할 일 목록을 가져옴
                List<Task> userTasks = project.getUserTasks(user.getUserId());
                // 모든 할 일이 완료되었는지 확인
                if (!userTasks.isEmpty() && !userTasks.stream().allMatch(Task::isCompleted)) {
                    System.out.println("해당 프로젝트의 할 일이 완료되지 않았습니다.");
                    return;
                }
            }
            System.out.println("해당 프로젝트의 모든 할 일이 완료되었습니다.");
        } else {
            System.out.println("해당 프로젝트를 찾을 수 없습니다.");
        }
    }

    // Getter 메서드
    public ArrayList<Project> getProjects() {
        return projects; // 프로젝트 목록 반환
    }

    public int getProjectCount() {
        return projectCount; // 프로젝트 수 반환
    }

    public TaskQueue getTaskQueue() {
        return taskQueue; // 작업 큐 반환
    }

    public TaskStack getTaskStack() {
        return taskStack; // 작업 스택 반환
    }

    // Setter 메서드 (선택적, 사용되지 않을 수 있음)
    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    public void setTaskQueue(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void setTaskStack(TaskStack taskStack) {
        this.taskStack = taskStack;
    }
}
