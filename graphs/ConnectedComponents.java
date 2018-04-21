package graphs;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConnectedComponents {
  static boolean[] visited;
  static ArrayList<Integer[]> graph;
  public static void main(String[] args) {
    graph = new ArrayList<>();
    
    graph.add(new Integer[]{3, 6});
    graph.add(new Integer[] {3, 4, 5, 6});
    graph.add(new Integer[] {8});
    graph.add(new Integer[] {0, 1, 5});
    graph.add(new Integer[] {1, 6});
    graph.add(new Integer[] {1, 3});
    graph.add(new Integer[] {0, 1, 4});
    graph.add(new Integer[] {});
    graph.add(new Integer[] {2});
    
    visited = new boolean[graph.size()];
    
    int totalConnectedAreaCount = 0;
    
    for (int i = 0; i < graph.size(); i++) {
      if (!visited[i]) {
        DFS(i);
        totalConnectedAreaCount++;
        System.out.println();
      }
    }
    
    System.out.println(totalConnectedAreaCount);
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

}
