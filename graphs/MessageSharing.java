package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class MessageSharing {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static Map<String, Integer> nameIdMappings = new TreeMap<>();
  static List<String> names = new ArrayList<>();
  static List<Integer> startingNodes = new ArrayList<>();
  static int minStepsReached = 0;
  static Stack<Integer> peopleAtLastStep = new Stack<>();

  public static void main(String[] args) {
    takeInput();
    
    if (startingNodes.size() == nameIdMappings.size()) {
      System.out.println("All people reached in 0 steps");
      System.out.print("People at last step: ");
      StringBuilder sBuilder = new StringBuilder();
      for (Entry<String, Integer> entry : nameIdMappings.entrySet()) {
        sBuilder.append(entry.getKey() + ", ");
      }
      
      System.out.print(sBuilder.toString().substring(0, sBuilder.length() - 2));
      
      return;
    }
    
    for (Integer start : startingNodes) {
      if (!visited[start]) {
        int steps = BFS(start);
         if (steps > minStepsReached) {
           minStepsReached = steps;
         }
      }
    }
    System.out.println("All people reached in " + minStepsReached + " steps");
    System.out.println("People at last step: " + names.get(peopleAtLastStep.pop()));
  }
  
  public static int BFS(int node) {
    Queue<Integer> queue = new LinkedList<Integer>();
    int[] level = new int[visited.length];
    
    queue.add(node);
    visited[node] = true;
    level[node] = 0;
    
    while (!queue.isEmpty()) {
      int c = queue.poll();
      peopleAtLastStep.push(c);
      System.out.print(c + " ");
      for (Integer child : graph[c]) {
        if (!visited[child]) {
          queue.add(child);
          visited[child] = true;
          level[child] = level[c] + 1;   
        }
      }
    }
    int max = 0;
    for (int i = 0; i < level.length; i++) {
      if (level[i] > max) {
        max = level[i];
      }
    }
    
    return max;
  }

  static void takeInput() {
    Scanner scanner = new Scanner(System.in);
    String[] peopleLineParams = scanner.nextLine().split(": ");
    String[] people = peopleLineParams[1].split(", ");
    
    for (int i = 0; i < people.length; i++) {
      nameIdMappings.put(people[i], i);
      names.add(people[i]);
    }
    graph = new ArrayList[nameIdMappings.size()];
    visited = new boolean[nameIdMappings.size()];
    
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    
    String[] connections = scanner.nextLine().split(": ")[1].split(", ");
    
    for (int i = 0; i < connections.length; i++) {
      String[] connectionParams = connections[i].split(" - ");
      
      int leftIdx = nameIdMappings.get(connectionParams[0]);
      int rightIdx = nameIdMappings.get(connectionParams[1]);
      
      graph[leftIdx].add(rightIdx);
      graph[rightIdx].add(leftIdx);
    }
    
    String[] startParams = scanner.nextLine().split(": ");
    
    String[] startingPeople = startParams[1].split(", ");
    
    for (int i = 0; i < startingPeople.length; i++) {
      startingNodes.add(nameIdMappings.get(startingPeople[i]));
    }
  }
}
