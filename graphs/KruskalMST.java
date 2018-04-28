package graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class KruskalMST {
	static ArrayList<Edge> edges;

	public static void main(String[] args) {
		edges = new ArrayList<>();

		edges.add(new Edge(0, 1, 4));
		edges.add(new Edge(1, 3, 2));
		edges.add(new Edge(0, 2, 5));
		edges.add(new Edge(0, 3, 9));
		edges.add(new Edge(2, 3, 20));
		edges.add(new Edge(2, 4, 7));
		edges.add(new Edge(3, 4, 8));
		edges.add(new Edge(4, 5, 12));
		edges.add(new Edge(6, 7, 8));
		edges.add(new Edge(7, 8, 7));
		edges.add(new Edge(6, 8, 10));

		dijkstraShortestPath();
	}
	
	public static void dijkstraShortestPath() {
		Map<Integer, List<Edge>> adjacent = new TreeMap<>();
		
		for (Edge edge : edges) {
			if (!adjacent.containsKey(edge.first)) {
				adjacent.put(edge.first, new ArrayList<>());
			}
			adjacent.get(edge.first).add(edge);
			
			if (!adjacent.containsKey(edge.second)) {
				adjacent.put(edge.second, new ArrayList<>());
			}
		
			adjacent.get(edge.second).add(edge);
		}
		
		HashSet<Integer> uniqueNodes = new HashSet<>();

		for (Edge edge : edges) {
			uniqueNodes.add(edge.first);
			uniqueNodes.add(edge.second);
		}

		int maxValue = maxValue(uniqueNodes);

		int[] distances = new int[maxValue + 1];
		int[] prev = new int[maxValue + 1];
		int minDistance = Integer.MAX_VALUE;
		int minDistanceIdx = -1;
		
		distances[0] = 0;
		
		for (int i = 1; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		
		Set<Integer> queue = new TreeSet<>((o1, o2) -> distances[o1] - distances[o2]);
		
		queue.add(0);
		
		while (queue.size() > 0) {
			Iterator iterator = queue.iterator();
			int first = (int) iterator.next();
			
			queue.remove(first);
			
			for (Edge child : adjacent.get(first)) {
				int otherNode = child.first == first ? child.second : child.first;
				
				if (distances[otherNode] == Integer.MAX_VALUE) {
					queue.add(otherNode);
				}
				
				int newDistance = distances[first] + child.weight;
				
				if (newDistance < distances[otherNode]) {
					distances[otherNode] = newDistance;
					queue.remove(otherNode);
					queue.add(otherNode);
					prev[otherNode] = first;
				}
			}
		}
		
		for (int i = distances.length - 1; i >= 0; i--) {
			if (distances[i] != Integer.MAX_VALUE) {
				minDistance = distances[i];
				minDistanceIdx = i;
				break;
			}
		}
		
		System.out.println("Minimum distance: " + minDistance + "; Min distance idx: " + minDistanceIdx);
	}

	public static List<Edge> kruskalMST() {
		HashSet<Integer> uniqueNodes = new HashSet<>();

		for (Edge edge : edges) {
			uniqueNodes.add(edge.first);
			uniqueNodes.add(edge.second);
		}

		int maxValue = maxValue(uniqueNodes);

		int[] parents = new int[maxValue + 1];

		// Initialize the parents
		for (int i : uniqueNodes) {
			parents[i] = i;
		}

		// Sort the edges by weight
		Collections.sort(edges);

		ArrayList<Edge> result = new ArrayList<>();

		for (Edge edge : edges) {
			int firstRoot = findRoot(parents, edge.first);
			int secondRoot = findRoot(parents, edge.second);

			if (firstRoot != secondRoot) {
				System.out.println(edge.first + " - " + edge.second);
				result.add(edge);
				parents[firstRoot] = secondRoot;
			}
		}
		
		return result;
	}

	public static int findRoot(int[] parents, int node) {
		while (parents[node] != node) {
			node = parents[node];
		}

		return node;
	}

	public static int maxValue(Collection<Integer> col) {
		int maxValue = Integer.MIN_VALUE;

		for (Integer n : col) {
			if (n > maxValue) {
				maxValue = n;
			}
		}

		return maxValue;
	}

}
