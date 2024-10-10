package task.management;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private ArrayList<Project> projects; 
    private int projectCount;             
    private TaskQueue taskQueue;          
    private TaskStack taskStack;          

    // 생성자
    public TaskManager() {
        this.projects = new ArrayList<>(); 
        this.projectCount = 0;              
        this.taskQueue = new TaskQueue();   
        this.taskStack = new TaskStack();   
    }

    
    public void registerProject(Project project) {
        if (projectCount < 5) {
            projects.add(project);
            projectCount++;
        } else {
            System.out.println("프로젝트를 더 이상 등록할 수 없습니다.");
        }
    }

    
    public Project getProjectById(String projectId) {
        for (Project project : projects) {
            if (project.getProjectId().equals(projectId)) {
                return project; 
            }
        }
        return null; 
    }

  
    public void assignTaskToUserInProject(String projectId, String userId, Task task) {
        Project project = getProjectById(projectId);
        if (project != null) {
            project.assignTaskToUser(userId, task);
        }
    }

    
    public void enqueueTask(Task task) {
        taskQueue.addTask(task);
    }

    
    public void dequeueTask() {
        Task task = taskQueue.removeTask();
        if (task != null) {
            task.completeTask(); 
        }
    }

   
    public void pushTask(Task task) {
        taskStack.pushTask(task);
    }

    
    public void popTask() {
        Task task = taskStack.popTask();
        if (task != null) {
            task.completeTask(); 
        }
    }

   
    public void printAllProjectsInfo() {
        for (Project project : projects) {
            System.out.println("Project ID: " + project.getProjectId());
            System.out.println("Title: " + project.getTitle());
            System.out.println("Users: " + project.getUserList().size());

            
            for (User user : project.getUserList()) {
                System.out.println("User ID: " + user.getUserId());
                List<Task> userTasks = project.getUserTasks(user.getUserId());
                System.out.println("Tasks: " + userTasks);
            }

            System.out.println("-----------------------------");
        }
    }


    public void checkProjectHealth(String projectId) {
        Project project = getProjectById(projectId);
        if (project != null) {
            for (User user : project.getUserList()) {

                List<Task> userTasks = project.getUserTasks(user.getUserId());
              
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


    public ArrayList<Project> getProjects() {
        return projects; 
    }

    public int getProjectCount() {
        return projectCount; 
    }

    public TaskQueue getTaskQueue() {
        return taskQueue; 
    }

    public TaskStack getTaskStack() {
        return taskStack; 
    }

    
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
