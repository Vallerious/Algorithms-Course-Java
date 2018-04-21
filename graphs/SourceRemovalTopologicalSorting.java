package graphs;

import java.awt.List;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class SourceRemovalTopologicalSorting {
  static boolean[] visited;
  public static void main(String[] args) {
    java.util.List<Integer> resultMap = Arrays.asList(5, 7, 8, 11, 9, 3, 2, 10);

    ArrayList<Integer[]> graph = new ArrayList<>();
    
    graph.add(new Integer[] {3});
    graph.add(new Integer[] {3, 2});
    graph.add(new Integer[] {4});
    graph.add(new Integer[] {4, 7, 6});
    graph.add(new Integer[] {});
    graph.add(new Integer[] {2, 7});
    graph.add(new Integer[] {});
    graph.add(new Integer[] {});

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
    
    for (Integer node : sorted) {
      System.out.print(resultMap.get(node) + " ");
    }
  }
  
  public static int findNodeToRemove(TreeMap<Integer, Integer> depenCountMap, Stack<Integer> sorted) {
    int idx = -1;
    
    for (java.util.Map.Entry<Integer, Integer> entry : depenCountMap.entrySet()) {
      if (entry.getValue() == 0 && !sorted.contains(entry.getKey())) {
        idx = entry.getKey();
        break;
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
