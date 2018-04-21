package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class DFSTopologicalSorting {
  private static Map<String, ArrayList<String>> graph;
  private static HashSet<String> visited;

  public static void main(String[] args) {
    graph = new TreeMap<>();
    graph.put("A", new ArrayList(Arrays.asList("B", "C")));
    graph.put("B", new ArrayList(Arrays.asList("D", "E")));
    graph.put("C", new ArrayList(Arrays.asList("F")));
    graph.put("D", new ArrayList(Arrays.asList("C", "F")));
    graph.put("E", new ArrayList(Arrays.asList("D")));
    graph.put("F", new ArrayList<>());
    visited = new HashSet<>();
    
    Collection<String> reStrings = topologicalSort();
    
    for (String string : reStrings) {
      System.out.print(string + " ");
    }
  }
  
  public static Collection<String> topologicalSort() {
    LinkedList<String> sorted = new LinkedList<>();
    
    for (String node : graph.keySet()) {
      DFS(node, sorted);
    }
    
    return sorted;
  }

  private static void DFS(String node, LinkedList<String> sorted) {
    if (!visited.contains(node)) {
      visited.add(node);
      
      for (String child : graph.get(node)) {
        DFS(child, sorted);
      }
      
      sorted.addFirst(node);
    }
  }

}
