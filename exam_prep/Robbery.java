package exam_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Robbery {
  static class Edge {
    int first;
    int second;
    int weight;
    
    public Edge(int first, int second, int weight) {
      this.first = first;
      this.second = second;
      this.weight = weight;
    }
  }
  
  static boolean[] cameraStatus;
  static int totalEnergy;
  static int waitEnergy;
  static int startNode;
  static int endNode;
  static int totalExxausted = 0;
  static List<Edge> graph;
  static int programState = 0;
  static boolean[] visited;
  static Map<Integer, List<Edge>> nodesToEdges;
  
  public static void main(String[] args) {
    takeInput();
    dijkstra();
    System.out.println(totalEnergy - totalExxausted);
  }
  
  static void dijkstra() {
    int[] distances = new int[graph.size() + 100000];
    
    for (int i = 0; i < distances.length; i++) {
      distances[i] = Integer.MAX_VALUE;
    }
    
    distances[startNode] = 0;
    
    Set<Integer> queue = new TreeSet<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return distances[o1] - distances[o2];
      }
    });
    
    queue.add(startNode);
    switchLights();
    while (!queue.isEmpty()) {
      Iterator<Integer> iterator = queue.iterator();
      int min = iterator.next();
      iterator.remove();
      
      if (visited[min]) {
        continue;
      }
      
      visited[min] = true;
      programState++;
      switchLights();
      for (Edge edge : nodesToEdges.get(min)) {
        int otherNode = edge.first == min ? edge.second : edge.first;
        if (distances[otherNode] == Integer.MAX_VALUE) {
          queue.add(otherNode);
        }
        int weight = edge.weight;
        
        if (!cameraStatus[otherNode]) {
          weight += waitEnergy;
        }
        
        int newDistance = distances[min] + weight;
        
        if (newDistance < distances[otherNode]) {
          distances[otherNode] = newDistance;
          queue.remove(otherNode);
          queue.add(otherNode);
        }
        
        if (otherNode == endNode) {
          totalExxausted = distances[endNode];
          return;
        }
      }
    }
  }
  
  static void switchLights() {
    for (int i = 0; i < cameraStatus.length; i++) {
      cameraStatus[i] = !cameraStatus[i];
    }
  }
  
  static void takeInput() {
    Scanner sc = new Scanner(System.in);
    setCameraStatuses(sc.nextLine());
    totalEnergy = Integer.parseInt(sc.nextLine());
    waitEnergy = Integer.parseInt(sc.nextLine());
    startNode = Integer.parseInt(sc.nextLine());
    endNode = Integer.parseInt(sc.nextLine());
    int n = Integer.parseInt(sc.nextLine());
    graph = new ArrayList<>();
    nodesToEdges = new TreeMap<>();
    visited = new boolean[cameraStatus.length];
    
    for (int i = 0; i < n; i++) {
      int[] params = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      
      graph.add(new Edge(params[0], params[1], params[2]));
    }
    
    initNodesToEdges();
  }
  
  static void initNodesToEdges() {
    for (Edge edge : graph) {
      if (!nodesToEdges.containsKey(edge.first)) {
        nodesToEdges.put(edge.first, new ArrayList<>());
      }
      
      nodesToEdges.get(edge.first).add(edge);
      
      if (!nodesToEdges.containsKey(edge.second)) {
        nodesToEdges.put(edge.second, new ArrayList<>());
      }
      
      nodesToEdges.get(edge.second).add(edge);
    }
  }
  
  static void setCameraStatuses(String line) {
    String[] parsed = line.split(" ");
    cameraStatus = new boolean[parsed.length];
    
    for (int i = 0; i < parsed.length; i++) {
      cameraStatus[i] = parsed[i].charAt(1) == 'b' ? false : true;
    }
  }

}
