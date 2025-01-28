package com.day1;

//class process
class Process {
    int processID;
    int burstTime;
    int priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processID) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process current = head;
        Process prev = tail;
        do {
            if (current.processID == processID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                if (head == current) {
                    head = null; // Last process removed
                }
                System.out.println("Process " + processID + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process ID " + processID + " not found.");
    }

    // Simulate the round-robin scheduling
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = getProcessCount();

        System.out.println("Starting Round Robin Scheduling with Time Quantum: " + timeQuantum);

        while (head != null) {
            Process current = head;
            do {
                int executionTime = Math.min(current.burstTime, timeQuantum);
                current.burstTime -= executionTime;

                System.out.println("Process " + current.processID + " executed for " + executionTime + " time units.");

                Process nextProcess = current.next;

                if (current.burstTime <= 0) {
                    totalTurnAroundTime += totalWaitingTime + executionTime;
                    removeProcess(current.processID);
                } else {
                    totalWaitingTime += executionTime;
                }

                // Break if the list becomes empty
                if (head == null) {
                    break;
                }

                current = nextProcess;
            } while (current != head);
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) processCount));
        System.out.println("Average Turn-Around Time: " + (totalTurnAroundTime / (double) processCount));
    }

    public int getProcessCount() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Process current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}

class RoundSchedulingAlgorithm {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);

        scheduler.simulateScheduling();
    }
}

