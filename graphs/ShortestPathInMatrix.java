package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ShortestPathInMatrix {
  static class Node implements Comparable<Node> {
    public int rowIdx;
    public int colIdx;
    
    public Node(int row, int col) {
      this.rowIdx = row;
      this.colIdx = col;
    }

    public boolean equals(Object o) {
      return this.hashCode() == o.hashCode();
    }
    
    @Override
    public int hashCode()
    {
        return (this.rowIdx + "-" + this.colIdx).hashCode();
    }

    @Override
    public int compareTo(Node o) {
      return this.hashCode() - o.hashCode();
    }
  }
  static class Edge {
    public Node first;
    public Node second;
    public int weight;
  }
  
  static int rowCount = 0;
  static int colCount = 0;
  static int[][] matrix;
  static List<Edge> graph = new ArrayList<>();
  static Map<Node, List<Edge>> nodeToEdges = new HashMap<>();
  static Set<Node> nodes = new TreeSet<>();

  public static void main(String[] args) {
    takeInput();
    transformMatrixToGraph();
    fillNodeToEdges();
    getUniqueNodesOrderByWeight();
    dijkstra();
    System.out.println();
  }
  
  public static void dijkstra() {
    Map<Node, Integer> distances = new HashMap<>();
    Map<String, Node> prev = new HashMap<>();
    
    for (Node node : nodes) {
      distances.put(node, Integer.MAX_VALUE);
    }
    
    Node startingNode = nodes.iterator().next();
    distances.put(startingNode, matrix[startingNode.rowIdx][startingNode.colIdx]);
    
    Set<Node> queue = new TreeSet<>(new Comparator<Node>() {

      @Override
      public int compare(Node o1, Node o2) {
        return distances.get(o1) - distances.get(o2);
      }
    });
    
    queue.add(startingNode);
    
    while (queue.size() > 0) {
      Iterator<Node> i = queue.iterator();
      Node min = i.next();
      i.remove();
      
      if (distances.get(min) == Integer.MAX_VALUE) break;
      for (Edge edge : nodeToEdges.get(min)) {
        Node otherNode = edge.first.equals(min) ? edge.second : edge.first; 
        if (distances.get(otherNode) == Integer.MAX_VALUE) {
          queue.add(otherNode);
        }
        
        int newDistance = distances.get(min) + matrix[otherNode.rowIdx][otherNode.colIdx];
        
        if (newDistance < distances.get(otherNode)) {
          distances.put(otherNode, newDistance);
          queue.remove(otherNode);
          queue.add(otherNode);
          prev.put(otherNode.rowIdx + "-" + otherNode.colIdx, min);
        }
      }
    }
    
    List<Node> results = new ArrayList<>();
    int initialRowIdx = rowCount - 1;
    int initialColIdx = colCount - 1;
    results.add(new Node(initialRowIdx, initialColIdx));
    while (initialRowIdx != 0 || initialColIdx != 0) {
      Node prevNode = prev.get(initialRowIdx + "-" + initialColIdx);
      results.add(prevNode);
      initialRowIdx = prevNode.rowIdx;
      initialColIdx = prevNode.colIdx;
    }
//    results.add(new Node(0, 0));
    Collections.reverse(results);
    System.out.println("Length: " + distances.get(new Node(rowCount - 1, colCount - 1)));
    System.out.print("Path: ");
    for (Node node : results) {
      System.out.print(matrix[node.rowIdx][node.colIdx] + " ");
    }
  }
  
  public static void getUniqueNodesOrderByWeight() {
    for (Edge edge : graph) {
      nodes.add(edge.first);
      nodes.add(edge.second);
    }
  }
  
  static void fillNodeToEdges() {
    for (Edge edge : graph) {
      if (!nodeToEdges.containsKey(edge.first)) {
        nodeToEdges.put(edge.first, new ArrayList<>());
      }
      
      if (!nodeToEdges.containsKey(edge.second)) {
        nodeToEdges.put(edge.second, new ArrayList<>());
      }
      
      nodeToEdges.get(edge.first).add(edge);
      nodeToEdges.get(edge.second).add(edge);
    }
  }
  
  static void transformMatrixToGraph() {
    boolean[][] visited = new boolean[rowCount][colCount];
    for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
      for (int colIdx = 0; colIdx < colCount; colIdx++) {
        // Check right
        if (!visited[rowIdx][colIdx]) {
          
          if (colIdx + 1 < colCount) {
            Edge newEdge = new Edge();
            newEdge.first = new Node(rowIdx, colIdx);
            newEdge.second = new Node(rowIdx, colIdx + 1);
            newEdge.weight = matrix[rowIdx][colIdx + 1];
            visited[rowIdx][colIdx + 1] = true;
            graph.add(newEdge);
          }
          
          // check down
          if (rowIdx + 1 < rowCount) {
            Edge newEdge = new Edge();
            newEdge.first = new Node(rowIdx, colIdx);
            newEdge.second = new Node(rowIdx + 1, colIdx);
            newEdge.weight = matrix[rowIdx + 1][colIdx];
            visited[rowIdx + 1][colIdx] = true;
            graph.add(newEdge);
          }
          
          // check left
          if (colIdx - 1 >= 0) {
            Edge newEdge = new Edge();
            newEdge.first = new Node(rowIdx, colIdx);
            newEdge.second = new Node(rowIdx, colIdx - 1);
            newEdge.weight = matrix[rowIdx][colIdx - 1];
            visited[rowIdx][colIdx - 1] = true;
            graph.add(newEdge);
          }
          
          // check up
          if (rowIdx - 1 >= 0) {
            Edge newEdge = new Edge();
            newEdge.first = new Node(rowIdx, colIdx);
            newEdge.second = new Node(rowIdx - 1, colIdx);
            newEdge.weight = matrix[rowIdx - 1][colIdx];
            visited[rowIdx - 1][colIdx] = true;
            graph.add(newEdge);
          }
        }
      }
    }
  }
  
  static void takeInput() {
    Scanner scanner = new Scanner(System.in);
    
    rowCount = Integer.parseInt(scanner.nextLine());
    colCount = Integer.parseInt(scanner.nextLine());
    matrix = new int[rowCount][colCount];
    for (int i = 0; i < rowCount; i++) {
      String[] line = scanner.nextLine().split(" ");
      
      for (int j = 0; j < colCount; j++) {
        matrix[i][j] = Integer.parseInt(line[j]);
      }
    }
  }

}
