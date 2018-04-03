package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProcessorScheduling {
  static List<Task> tasks;
  static List<Task> completedTasksNumbers = new ArrayList<>();
  static int totalTasks;
  static int totalValue = 0;

  public static void maina(String[] args) {
    // TODO Auto-generated method stub
    takeInput();
    Collections.sort(tasks, new TaskComparator());
    int maxDeadline = maxDeadline(tasks);

    List<Task> filteredTasks = tasks.stream()
         .filter(tasks -> tasks.deadline <= maxDeadline)
         .collect(Collectors.toList());
    
    int tick = maxDeadline;
    int idx = 0;
    
    while (tick > 0) {
      Task currentTask = tasks.get(idx);
      
//      if (currentTask.deadline >= tick) {
        totalValue += currentTask.value;
        completedTasksNumbers.add(currentTask);
        tick--;
//      }
      
      idx++;
    }
    
    Collections.sort(completedTasksNumbers, new TaskDisplayComparator());
    
    String scheduleInfo = completedTasksNumbers.stream()
        .map(task -> task.taskNumber + "")
        .collect(Collectors.joining(" -> "));
    
    System.out.println("Optimal schedule: " + scheduleInfo);
    System.out.print("Total value: " + totalValue);
  }
  
  private static void takeInput() {
    Scanner scanner = new Scanner(System.in);
    totalTasks = Integer.parseInt(scanner.nextLine().split(" ")[1]);
    tasks = new ArrayList<>();

    for (int i = 0; i < totalTasks; i++) {
      String[] line = scanner.nextLine().split(" - ");
      
      tasks.add(new Task(i + 1, Integer.parseInt(line[0]), Integer.parseInt(line[1])));
    }
  }
  
  private static int maxDeadline(List<Task> tasks) {
    int maxDeadline = -1;
    
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).deadline > maxDeadline) {
        maxDeadline = tasks.get(i).deadline;
      }
    }
    
    return maxDeadline;
  }
  
  private static class Task {
    public int taskNumber;
    public int value;
    public int deadline;
    
    public Task(int taskNumber, int value, int deadline) {
      this.taskNumber = taskNumber;
      this.value = value;
      this.deadline = deadline;
    }
  }
  
  private static class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
      if (o1.value == o2.value) {
        return o2.deadline - o1.deadline;
      }
      
      return o2.value - o1.value;
    }
    
  }
  
  private static class TaskDisplayComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
      if (o1.deadline == o2.deadline) {
        return o2.value - o1.value;
      }
      
      return o1.deadline - o2.deadline;
    }
    
  }

}
