package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class TopologicalSorting {
  static ArrayList<ArrayList<Integer>> graph;
  public static void main(String[] args) {
    graph = new ArrayList<ArrayList<Integer>>() {{
      add(new ArrayList<Integer>() {{
        add(1);
        add(2);
      }});
      
      add(new ArrayList<Integer>() {{
        add(3);
        add(4);
      }});
      
      add(new ArrayList<Integer>() {{
        add(5);
      }});
      
      add(new ArrayList<Integer>() {{
        add(5);
        add(2);
      }});
      
      add(new ArrayList<Integer>() {{
        add(3);
      }});
      
      add(new ArrayList<Integer>());
    }};
    
    ArrayList<Integer> result = new ArrayList<>();
    TreeSet<Integer> nodes = new TreeSet<>();
    HashSet<Integer> nodesWithEdges = new HashSet<>();
    
    for (ArrayList<Integer> node : graph) {
      nodesWithEdges.addAll(node);
    }
    
    for (int i = 0; i < graph.size(); i++) {
      if (!nodesWithEdges.contains(i)) {
        nodes.add(i);
      }
    }
    
    
    while (nodes.size() > 0) {
      int currentNode = nodes.first();
      result.add(currentNode);
      nodes.remove(currentNode);
      
      ArrayList<Integer> children = (ArrayList<Integer>) graph.get(currentNode).clone();
      graph.set(currentNode, new ArrayList<>());
      
      nodesWithEdges = new HashSet<>();
      
      for (ArrayList<Integer> node : graph) {
        nodesWithEdges.addAll(node);
      }
      for (Integer child : children) {
        if (!nodesWithEdges.contains(child)) {
          nodes.add(child);
        }
      }
      
    }
    int countOfElementsInGraph = 0;
    
    for (ArrayList<Integer> node : graph) {
      countOfElementsInGraph += node.size();
    }
    if (countOfElementsInGraph > 0) {
      System.out.println("We have a cycle here");
    } else {
      System.out.println("We do not have a cycle here!");
      result.forEach(System.out::print);
    }
    System.out.println();
  }

}
