package task;

import task.management.Project;
import task.management.Task;
import task.management.TaskManager;
import task.management.User;



public class App {
    public static void main(String[] args) {
      
        TaskManager taskManager = new TaskManager();

       
        Project project1 = new Project("P001", "Project Alpha");
        Project project2 = new Project("P002", "Project Beta");

      
        taskManager.registerProject(project1);
        taskManager.registerProject(project2);

       
        User user1 = new User("U001", "Alice");
        User user2 = new User("U002", "Bob");

     
        project1.addUser(user1);
        project1.addUser(user2);
        project2.addUser(user1); 

       
        Task task1 = new Task("T001", "Design UI", 1);
        Task task2 = new Task("T002", "Implement Backend", 2);
        Task task3 = new Task("T003", "Write Documentation", 3);

      
        taskManager.assignTaskToUserInProject("P001", "U001", task1);
        taskManager.assignTaskToUserInProject("P001", "U002", task2);
        taskManager.assignTaskToUserInProject("P002", "U001", task3);

       
        System.out.println("=== All Projects Info ===");
        taskManager.printAllProjectsInfo();

        
        System.out.println("\n=== Checking Project Health ===");
        taskManager.checkProjectHealth("P001");
        taskManager.checkProjectHealth("P002");

       
        task1.completeTask(); 
        task2.completeTask(); 

        
        System.out.println("\n=== Checking Project Health After Completing Tasks ===");
        taskManager.checkProjectHealth("P001");
        taskManager.checkProjectHealth("P002");

   
        System.out.println("\n=== Final Projects Info ===");
        taskManager.printAllProjectsInfo();
    }
}
