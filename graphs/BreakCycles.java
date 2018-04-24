package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class BreakCycles {
	static Map<Character, ArrayList<Character>> graph;
	public static void main(String[] args) {
		parseInput();
		List<String> results = new ArrayList<>();
		
		for (Entry<Character, ArrayList<Character>> entry : graph.entrySet()) {
			ArrayList<Character> connections = entry.getValue();
			char first = entry.getKey();
			Collections.sort(connections);
			
			for (ListIterator<Character> iterator = connections.listIterator(); iterator.hasNext();) {
				Character second = (Character) iterator.next();
				
				iterator.remove();
				graph.get(second).removeIf(c -> c == first);
				
				if (hasPath(first, second)) {
					results.add(first + " - " + second);
				} else {
					iterator.add(second);
					graph.get(second).add(first);
				}
			}
		}
		
		System.out.println("Edges to remove: " + results.size());
		for (String string : results) {
			System.out.println(string);
		}
	}
	
	private static boolean hasPath(char first, Character second) {
		// Implement BFS
		Set<Character> visited = new HashSet<>();
		
		Queue<Character> queue = new LinkedList<>();
		
		visited.add(first);
		queue.add(first);
		
		while (!queue.isEmpty()) {
			// pop a character from the queue - the first in is first out :)
			char currentNode = queue.poll();
			
			Iterator<Character> i = graph.get(currentNode).listIterator();
			
			while (i.hasNext()) {
				char end = i.next();
				
				if (!visited.contains(end)) {
					visited.add(end);
					queue.add(end);
					
					if (end == second) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	public static void parseInput() {
		Scanner scanner = new Scanner(System.in);
		Map<Character, ArrayList<Character>> parsedgraph = new TreeMap<Character, ArrayList<Character>>();
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			if (line.isEmpty()) {
				break;
			}
			
			String[] params1 = line.split(" -> ");
			char node = params1[0].charAt(0);
			parsedgraph.put(node, new ArrayList<>());
			
			String[] edges = params1[1].split(" ");
			
			for (String string : edges) {
				parsedgraph.get(node).add(string.charAt(0));
			}
		}
		
		graph = parsedgraph;
	}

}
