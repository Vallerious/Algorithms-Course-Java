package graphs;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArticulationPoints {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static HashSet<Integer> visitedNodes;
	public static void main(String[] args) {
		graph = new ArrayList<>();
		
		
		graph.add(new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(6);
			add(7);
			add(9);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(0);
			add(6);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(0);
			add(7);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(4);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(3);
			add(6);
			add(10);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(7);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(0);
			add(1);
			add(4);
			add(8);
			add(10);
			add(11);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(0);
			add(2);
			add(5);
			add(9);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(6);
			add(11);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(0);
			add(7);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(4);
			add(6);
		}});
		
		graph.add(new ArrayList<Integer>() {{
			add(6);
			add(8);
		}});
		
		
		List<Integer> articulatedPoints = new ArrayList<>();
		
		for (int node = 0; node < graph.size(); node++) {
			visited = new boolean[graph.size()];
			visitedNodes = new HashSet<>();
			
			List<Integer> currentNode = (List<Integer>) graph.get(node).clone();
			graph.set(node, new ArrayList<>());
			
			DFS(node == 0 ? 1 : 0);
			
			if (visitedNodes.size() < graph.size()) {
				articulatedPoints.add(node);
				graph.set(node, (ArrayList<Integer>) currentNode);
			} else {
				graph.set(node, (ArrayList<Integer>) currentNode);
			}
			
		}
		
		for (Integer integer : articulatedPoints) {
			System.out.println(integer);
		}
		
	}
	
	public static void DFS(int node) {
		if (!visited[node]) {
			visited[node] = true;
			
			for (Integer child : graph.get(node)) {
				DFS(child);
			}
			
			visitedNodes.add(node);
		}
	}

}
