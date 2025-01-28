package com.day1;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;
    private Task tail;
    private Task current;

    public TaskScheduler() {
        head = null;
        tail = null;
        current = null;
    }

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 0;

        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
            tail.next = head;
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head;
        Task prev = null;

        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }

                if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                }

                System.out.println("Task with ID " + taskId + " removed successfully.");
                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewAndMoveToNextTask() {
        if (current == null) {
            current = head;
        }

        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task: ID = " + current.taskId + ", Name = " + current.taskName
                + ", Priority = " + current.priority + ", Due Date = " + current.dueDate);
        current = current.next;
    }

    // Display all tasks starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("Tasks in the list:");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority
                    + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tasks by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}

public class TaskScheduling {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        scheduler.addTaskAtEnd(1, "Task 1", 3, "2025/02/01");
        scheduler.addTaskAtEnd(2, "Task 2", 1, "2025/02/05");
        scheduler.addTaskAtBeginning(3, "Task 3", 2, "2025/01/30");
        scheduler.addTaskAtPosition(4, "Task 4", 4, "2025/02/10", 2);

        // Display all tasks
        scheduler.displayAllTasks();
        System.out.println();

        // View current task and move to the next
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();
        System.out.println();

        // Search for tasks by priority
        scheduler.searchByPriority(2);
        System.out.println();

        // Remove a task by ID
        scheduler.removeTaskById(2);
        scheduler.displayAllTasks();
    }
}
