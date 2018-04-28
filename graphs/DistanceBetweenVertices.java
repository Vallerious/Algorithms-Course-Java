package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class DistanceBetweenVertices {
	public static Map<Integer, ArrayList<Integer>> graph;
	static ArrayList<String> startEndPairs;
	public static void main(String[] args) {
		graph = new TreeMap<>();
		startEndPairs = new ArrayList<>();
		takeInput();
		
		
		for (String pair : startEndPairs) {
			String[] params = pair.split("-");
			int start = Integer.parseInt(params[0]);
			int end = Integer.parseInt(params[1]);
			
			int result = BFS(start, end);
			System.out.println("{" + start + ", " + end + "} -> " + result);
		}
	}
	
	private static int BFS(int first, int second) {
		// Implement BFS
		Set<Integer> visited = new HashSet<>();
		int[] distance = new int[graph.size() + 1000];
		Queue<Integer> queue = new LinkedList<>();
		
		visited.add(first);
		queue.add(first);
		distance[first] = 0;
		
		while (!queue.isEmpty()) {
			// pop a character from the queue - the first in is first out :)
			int currentNode = queue.poll();
			
			Iterator<Integer> i = graph.get(currentNode).listIterator();
			
			while (i.hasNext()) {
				int end = i.next();
				
				if (!visited.contains(end)) {
					visited.add(end);
					queue.add(end);
					distance[end] = distance[currentNode] + 1;
				}
			}
		}
		
		return distance[second] == 0 ? -1 : distance[second];
	}

	public static void takeInput() {
		Scanner scanner = new Scanner(System.in);
		int numOfGraphNodes = Integer.parseInt(scanner.nextLine());
		int numberOfConnectionsToFindLengthOf = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < numOfGraphNodes; i++) {
			String line = scanner.nextLine();
			
			String[] params = line.split(":");
			int node = Integer.parseInt(params[0]);
			graph.put(node, new ArrayList<>());
			
			String[] edges;
			if (params.length <= 1) {
				edges = new String[0];
			} else {
				edges = params[1].split(" ");
			}
			
			for (String edge : edges) {
				graph.get(node).add(Integer.parseInt(edge));
			}
		}
		
		for (int i = 0; i < numberOfConnectionsToFindLengthOf; i++) {
			startEndPairs.add(scanner.nextLine());
		}
	}
}
