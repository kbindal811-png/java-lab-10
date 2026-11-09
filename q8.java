import java.util.Stack;

public class q8 {
    static class Task {
        private final int taskId;
        private final String description;

        public Task(int taskId, String description) {
            this.taskId = taskId;
            this.description = description;
        }

        public int getTaskId() { return taskId; }
        public String getDescription() { return description; }

        @Override
        public String toString() { return "Task " + taskId + ": " + description; }
    }

    static class TaskManager {
        private final Stack<Task> tasks = new Stack<>();

        public void pushTask(Task t) {
            tasks.push(t);
            System.out.println("Pushed -> " + t);
        }

        public void popCompletedTask() {
            if (tasks.isEmpty()) {
                System.out.println("No tasks to complete.");
            } else {
                System.out.println("Completed (popped) -> " + tasks.pop());
            }
        }

        public void displayRemaining() {
            System.out.println("--- Remaining Tasks (top first) ---");
            if (tasks.isEmpty()) System.out.println("(none)");
            for (int i = tasks.size() - 1; i >= 0; i--) {
                System.out.println(tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.pushTask(new Task(1, "Write report"));
        manager.pushTask(new Task(2, "Test code"));
        manager.pushTask(new Task(3, "Submit assignment"));
        manager.displayRemaining();

        manager.popCompletedTask();
        manager.popCompletedTask();
        manager.displayRemaining();
    }
}
