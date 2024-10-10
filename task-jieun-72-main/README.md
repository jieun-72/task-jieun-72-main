[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/bereUUbb)
# Task Management

## 제출 기한

- 10/15 23:59

## 구현 사항

- 아래의 클래스들을 `app/src/main/java`에 있는 `TaskManager.java`, `User.java`, `Task.java`, `Project.java`, `TaskQueue.java`, `TaskStack.java` 파일을 이용하여 구현한다.

### 1. **Task 클래스** (`task.management` 패키지에 위치):

- **필드**:
  - `taskId`: 할 일의 고유 ID를 나타내는 `String` 타입.
  - `description`: 할 일의 설명을 나타내는 `String` 타입.
  - `isCompleted`: 할 일의 완료 여부를 나타내는 `boolean` 타입.
  - `priority`: 할 일의 우선순위를 나타내는 `int` 타입.

- **생성자**:
  - `Task(String taskId, String description, int priority)`: `taskId`, `description`과 `priority`를 초기화하고, `isCompleted` 상태는 기본값 `false`로 설정한다.

- **메서드**:
  - `completeTask()`: 할 일의 `isCompleted` 상태를 `true`로 설정한다.
  - `setPriority(int priority)`: 주어진 `priority` 값을 설정한다.
  - `compareTo(Task other)`: 할 일의 `priority`를 기준으로 다른 `Task`와 비교하여 정렬할 수 있도록 한다.
  - **Getter 및 Setter 메서드**: 각 필드에 대해 `getter`와 `setter` 메서드를 구현한다.

### 2. **User 클래스** (`task.management` 패키지에 위치):

- **필드**:
  - `userId`: 사용자의 고유 ID를 나타내는 `String` 타입.
  - `name`: 사용자의 이름을 나타내는 `String` 타입.
  - `taskList`: 사용자가 가지고 있는 할 일 목록을 관리하는 `ArrayList<Task>` 타입.

- **생성자**:
  - `User(String userId, String name)`: `userId`, `name`을 초기화하고, `taskList`를 빈 리스트로 생성한다.

- **메서드**:
  - `addTask(Task task)`: 사용자에게 할 일을 추가한다.
  - `removeTask(String taskId)`: 주어진 ID의 할 일을 제거한다.
  - `getTaskById(String taskId)`: `taskId`에 해당하는 할 일을 반환한다. 없다면 `null` 반환.
  - `getTaskList()`: 사용자에게 할 일 목록을 반환한다.
  - **Getter 및 Setter 메서드**: 각 필드에 대해 `getter`와 `setter` 메서드를 구현한다.

### 3. **Project 클래스** (`task.management` 패키지에 위치):

- **필드**:
  - `projectId`: 프로젝트의 고유 ID를 나타내는 `String` 타입.
  - `title`: 프로젝트의 제목을 나타내는 `String` 타입.
  - `userList`: 프로젝트에 포함된 사용자 목록을 저장하는 `ArrayList<User>` 타입.
  - `taskMap`: 사용자의 `userId`를 키로 하고, 해당 사용자가 소유한 `Task` 목록을 `HashMap<String, ArrayList<Task>>`으로 관리.

- **생성자**:
  - `Project(String projectId, String title)`: `projectId`, `title`을 초기화하고, `userList`는 빈 리스트로 생성, `taskMap`은 빈 맵으로 초기화한다.

- **메서드**:
  - `addUser(User user)`: 프로젝트에 사용자를 추가한다.
  - `removeUser(String userId)`: 주어진 ID의 사용자를 프로젝트에서 제거한다.
  - `assignTaskToUser(String userId, Task task)`: 특정 사용자에게 할 일을 할당하고, `taskMap`에 저장한다.
  - `getUserTasks(String userId)`: 특정 사용자가 소유한 할 일 목록을 반환한다.
  - `getUserList()`: 프로젝트에 포함된 모든 사용자 목록을 반환한다.
  - **Getter 및 Setter 메서드**: 각 필드에 대해 `getter`와 `setter` 메서드를 구현한다.

### 4. **TaskQueue 클래스** (`task.management` 패키지에 위치):

- **필드**:
  - `taskQueue`: 할 일(Task)을 관리하는 `Queue<Task>` 타입의 큐를 정의.

- **생성자**:
  - `TaskQueue()`: `taskQueue`를 `LinkedList`로 초기화.

- **메서드**:
  - `addTask(Task task)`: 큐에 새로운 할 일을 추가한다.
  - `removeTask()`: 큐의 첫 번째 할 일을 제거하고 반환한다. 큐가 비어있으면 `null` 반환.
  - `peekTask()`: 큐의 첫 번째 할 일을 반환하지만, 큐에서 제거하지는 않는다.
  - `isEmpty()`: 큐가 비어있는지 여부를 반환한다.
  - `size()`: 큐에 남아있는 할 일의 수를 반환한다.
  - **Getter 및 Setter 메서드**: 각 필드에 대해 `getter`와 `setter` 메서드를 구현한다.

### 5. **TaskStack 클래스** (`task.management` 패키지에 위치):

- **필드**:
  - `taskStack`: 할 일(Task)을 관리하는 `Stack<Task>` 타입의 스택을 정의.

- **생성자**:
  - `TaskStack()`: `taskStack`을 `Stack`으로 초기화.

- **메서드**:
  - `pushTask(Task task)`: 스택에 새로운 할 일을 추가한다.
  - `popTask()`: 스택의 최상단에 있는 할 일을 제거하고 반환한다. 스택이 비어있으면 `null` 반환.
  - `peekTask()`: 스택의 최상단에 있는 할 일을 제거하지 않고 반환한다.
  - `isEmpty()`: 스택이 비어있는지 여부를 반환한다.
  - `size()`: 스택에 남아있는 할 일의 수를 반환한다.
  - **Getter 및 Setter 메서드**: 각 필드에 대해 `getter`와 `setter` 메서드를 구현한다.

### 6. **TaskManager 클래스** (`task.management` 패키지에 위치):

- **필드**:
  - 최대 5개의 프로젝트를 저장할 수 있는 `ArrayList<Project> projects` 변수를 정의한다.
  - 현재 등록된 프로젝트의 수를 나타내는 `int projectCount` 변수를 정의한다.
  - `TaskQueue`, `TaskStack` 인스턴스를 이용하여 할 일의 작업 큐와 스택을 각각 관리.

- **생성자**:
  - `TaskManager()`: `projects`를 빈 `ArrayList`로 초기화하고, `projectCount`는 0으로 설정하며, `TaskQueue`, `TaskStack` 인스턴스를 각각 생성.

- **메서드**:
  - `registerProject(Project project)`: 프로젝트 목록에 새로운 프로젝트를 등록한다. 여유 공간이 없으면 "프로젝트를 더 이상 등록할 수 없습니다" 메시지를 출력하고, 더 이상 등록하지 않는다.
  - `getProjectById(String projectId)`: 주어진 `projectId`에 해당하는 프로젝트를 반환한다.
  - `assignTaskToUserInProject(String projectId, String userId, Task task)`: 특정 프로젝트(`projectId`)의 특정 사용자(`userId`)에게 할 일을 할당한다.
  - `enqueueTask(Task task)`: 작업 큐에 새로운 할 일을 추가한다.
  - `dequeueTask()`: 큐에서 다음 할 일을 가져와 완료 처리한다.
  - `pushTask(Task task)`: 작업 스택에 새로운 할 일을 추가한다.
  - `popTask()`: 작업 스택에서 다음 할 일을 가져와 완료 처리한다.
  - `printAllProjectsInfo()`: 모든 프로젝트의 정보를 출력한다.
  - `checkProjectHealth(String projectId)`: 특정 프로젝트의 모든 사용자에 대해 할 일의 완료 여부를 확인하고, 완료되지 않은 할 일이 있을 경우 "해당 프로젝트의 할 일이 완료되지 않았습니다" 메시지를 출력한다.
  - **Getter 및 Setter 메서드**: 각 필드에 대해 `getter`와 `setter` 메서드를 구현한다.

### 7. **보고서 작성**:

- `REPORT.md` 파일을 작성하여 본인이 구현한 코드에서 사용한 자바 문법 및 알고리즘에 대해 간략히 설명하고, ChatGPT, GitHub Copilot 등 생성형 AI를 활용했다면 어떻게 활용했는지 방법을 작성한다.

### 8. **제출 및 테스트 방법**

- `App.java`의 `main` 메서드에서 테스트 코드를 작성하여 다양한 케이스를 테스트.
- `./gradlew run` (Windows 환경에서는 `./gradlew.bat run`) 명령어를 사용하여 main 메서드 실행 후 결과를 확인.
- `git add [파일명]`, `git commit -m [커밋로그]`, `git push` 명령어를 차례로 실행하여 제출.
- GitHub 저장소의 **Actions** 탭에서 JUnit 테스트 결과를 확인할 수 있으며, `run-autograding-test` 작업을 클릭하여 테스트 결과를 확인한다..