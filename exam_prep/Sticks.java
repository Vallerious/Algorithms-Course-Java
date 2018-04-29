package exam_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Sticks {
  static boolean[] visited;
  static int sticksCount;
  static ArrayList<Integer[]> graph;

  public static void main(String[] args) {
    takeInput();

    visited = new boolean[graph.size()];
    TreeMap<Integer, Integer> depenCount = getDependenciesCount(graph);
    Stack<Integer> sorted = new Stack<>(); 

    while (!isGraphEmpty(graph) || sorted.size() < graph.size()) {
      int nodeToRemoveIdx = findNodeToRemove(depenCount, sorted);
      
      if (nodeToRemoveIdx == -1) {
        break;
      }
      
      graph.set(nodeToRemoveIdx, new Integer[] {});
      sorted.add(nodeToRemoveIdx);
      depenCount = getDependenciesCount(graph);
    }
    
    if (sorted.size() < sticksCount) {
      System.out.println("Cannot lift all sticks");
    }
    
    for (Integer node : sorted) {
      System.out.print(node + " ");
    }
  }
  
  static void takeInput() {
    Scanner scanner = new Scanner(System.in);
    Map<Integer, ArrayList<Integer>> tempGraph = new TreeMap<>();
    
    sticksCount = Integer.parseInt(scanner.nextLine());
    int p = Integer.parseInt(scanner.nextLine());
    graph = new ArrayList<>(sticksCount);
    for (int i = 0; i < p; i++) {
      int[] nodeBond = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      
      if (!tempGraph.containsKey(nodeBond[0])) {
        tempGraph.put(nodeBond[0], new ArrayList<>());
      }
      
      tempGraph.get(nodeBond[0]).add(nodeBond[1]);
    }
    
    for (int i = 0; i < sticksCount; i++) {
      ArrayList<Integer> currentList;
      
      if (tempGraph.containsKey(i)) {
        currentList = tempGraph.get(i);
      } else {
        currentList = new ArrayList<>();
      }
      
      Integer[] currentConnectionArray = new Integer[currentList.size()];
      
      for (int j = 0; j < currentConnectionArray.length; j++) {
        currentConnectionArray[j] = currentList.get(j);
      }
      
      graph.add(currentConnectionArray);
    }
  }
  
  public static int findNodeToRemove(TreeMap<Integer, Integer> depenCountMap, Stack<Integer> sorted) {
    int idx = -1;
    
    for (java.util.Map.Entry<Integer, Integer> entry : depenCountMap.entrySet()) {
      if (entry.getValue() == 0 && !sorted.contains(entry.getKey())) {
        idx = entry.getKey();
      }
    }
    
    return idx;
  }
  
  public static boolean isGraphEmpty(ArrayList<Integer[]> graph) {
    boolean isEmpty = true;
    
    for (Integer[] integers : graph) {
      if (integers.length > 0) {
        isEmpty = false;
      }
    }
    
    return isEmpty;
  }
  
  public static TreeMap<Integer, Integer> getDependenciesCount(ArrayList<Integer[]> graph) {
    TreeMap<Integer, Integer> dependenciesCountMap = new TreeMap<>();
    int idx = 0;
    for (Integer[] arrayList : graph) {
      if (!dependenciesCountMap.containsKey(idx)) {
        dependenciesCountMap.put(idx, 0);
      }
      
      for (Integer child : arrayList) {
        if (!dependenciesCountMap.containsKey(child)) {
          dependenciesCountMap.put(child, 0);
        }
        
        dependenciesCountMap.put(child, dependenciesCountMap.get(child) + 1);
      }
      
      idx++;
    }
    
    return dependenciesCountMap;
  }
}
