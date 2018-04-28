package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BreakTheCycle {

  public static void main(String[] args) {
    Map<Character, List<Character>> graph = getInput();
    
    int count = 0;
    List<String> result = new ArrayList<>();
    
    for (Entry<Character, List<Character>> entry : graph.entrySet()) {
      char node = entry.getKey();
      Collections.sort(entry.getValue());
      for (Character edge : entry.getValue()) {
        graph.get(node).remove(edge);
      }
    }
  }
  
  public static Map<Character, List<Character>> getInput() {
    Map<Character, List<Character>> graph = new TreeMap<>();
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    try {
      while ((line = br.readLine()) != null) {
        if (line.isEmpty()) break;
        String[] params = line.split(" -> ");
        
        char nodeValue = params[0].charAt(0);
        String[] edges = params[1].split(" ");
        List<Character> edgesSet = new ArrayList<>();
        
        for (String edge : edges) {
          edgesSet.add(edge.charAt(0));
        }
        
        graph.put(nodeValue, edgesSet);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return graph;
  }

}
