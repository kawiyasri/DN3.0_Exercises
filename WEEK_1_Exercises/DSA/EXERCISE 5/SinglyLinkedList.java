public class SinglyLinkedList {
    private Node head;
    private int size;

    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Search for a task by ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(int taskId) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                if (previous == null) {
                    head = current.next; // Deleting head node
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        // Create some tasks
        Task t1 = new Task(1, "Task 1", "Incomplete");
        Task t2 = new Task(2, "Task 2", "Complete");
        Task t3 = new Task(3, "Task 3", "Incomplete");

        // Add tasks to the list
        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);

        // Display all tasks
        System.out.println("All tasks:");
        taskList.traverseTasks();

        // Search for a task
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("\nFound task: " + task);
        } else {
            System.out.println("\nTask not found.");
        }

        // Delete a task
        taskList.deleteTask(2);
        System.out.println("\nTasks after deletion:");
        taskList.traverseTasks();
    }
}
