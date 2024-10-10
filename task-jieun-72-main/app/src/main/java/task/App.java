package task;

import java.util.ArrayList;
import java.util.List;

import task.management.Project;
import task.management.Task;
import task.management.TaskManager;
import task.management.User;



public class App {
    public static void main(String[] args) {
        // TaskManager 인스턴스 생성
        TaskManager taskManager = new TaskManager();

        // 프로젝트 생성
        Project project1 = new Project("P001", "Project Alpha");
        Project project2 = new Project("P002", "Project Beta");

        // 프로젝트 등록
        taskManager.registerProject(project1);
        taskManager.registerProject(project2);

        // 사용자 생성
        User user1 = new User("U001", "Alice");
        User user2 = new User("U002", "Bob");

        // 사용자 추가
        project1.addUser(user1);
        project1.addUser(user2);
        project2.addUser(user1); // Alice도 Project Beta에 추가

        // 할 일 생성
        Task task1 = new Task("T001", "Design UI", 1);
        Task task2 = new Task("T002", "Implement Backend", 2);
        Task task3 = new Task("T003", "Write Documentation", 3);

        // 할 일 할당
        taskManager.assignTaskToUserInProject("P001", "U001", task1);
        taskManager.assignTaskToUserInProject("P001", "U002", task2);
        taskManager.assignTaskToUserInProject("P002", "U001", task3);

        // 모든 프로젝트 정보 출력
        System.out.println("=== All Projects Info ===");
        taskManager.printAllProjectsInfo();

        // 특정 프로젝트 건강 상태 확인
        System.out.println("\n=== Checking Project Health ===");
        taskManager.checkProjectHealth("P001");
        taskManager.checkProjectHealth("P002");

        // 할 일 완료 처리
        task1.completeTask(); // Alice가 UI 디자인을 완료
        task2.completeTask(); // Bob이 백엔드를 구현 완료

        // 건강 상태 재확인
        System.out.println("\n=== Checking Project Health After Completing Tasks ===");
        taskManager.checkProjectHealth("P001");
        taskManager.checkProjectHealth("P002");

        // 결과 확인
        System.out.println("\n=== Final Projects Info ===");
        taskManager.printAllProjectsInfo();
    }
}
