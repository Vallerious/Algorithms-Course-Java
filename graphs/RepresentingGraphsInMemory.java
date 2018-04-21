package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RepresentingGraphsInMemory {
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph;
  static int connectedAreasCount = 0;
  public static void main(String[] args) {
    graph = new ArrayList<ArrayList<Integer>>() {{
      add(new ArrayList<Integer>() {{
        add(3);
        add(6);
      }});
      
      add(new ArrayList<Integer>() {{
        add(3);
        add(6);
        add(4);
        add(2);
        add(5);
      }});
      
      add(new ArrayList<Integer>() {{
        add(4);
        add(1);
        add(5);
      }});
      
      add(new ArrayList<Integer>() {{
        add(0);
        add(1);
        add(5);
      }});
      
      add(new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(6);
      }});
      
      add(new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
      }});
      
      add(new ArrayList<Integer>() {{
        add(0);
        add(1);
        add(4);
      }});
      
      add(new ArrayList<Integer>() {{
        add(7);
      }});
    }};
    
    visited = new boolean[graph.size()];
    
    for (int i = 0; i < graph.size(); i++) {
      if (!visited[i]) {
        connectedAreasCount++;
        DFS(i);
      }
    }
    
    System.out.println("Connected areas count: " + connectedAreasCount);
  }
  
  public static void DFS(int node) {
    if (!visited[node]) {
      visited[node] = true;
      
      for (int child : graph.get(node)) {
        DFS(child);
      }
      
      System.out.print(node + " ");
    }
  }
  
  public static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<Integer>();
    
    queue.add(node);
    visited[node] = true;
    
    while (!queue.isEmpty()) {
      int c = queue.poll();
      
      System.out.print(c + " ");
      
      for (Integer child : graph.get(node)) {
        if (!visited[child]) {
          queue.add(child);
          visited[child] = true;
        }
      }
    }
  }

}
