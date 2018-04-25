package graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AreasInMatrix {
	static char[][] matrix;
	static boolean[][] visited;
	static int areas = 0;
	static Map<Character, Integer> result = new TreeMap<>();
	static Set<Character> charCollector = new HashSet<>();
	static int cols = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		matrix = new char[n][];
		visited = new boolean[n][];
		
		for (int i = 0; i < matrix.length; i++) {
			String line = scanner.nextLine();
			matrix[i] = new char[line.length()];
			visited[i] = new boolean[line.length()];
			cols = line.length();
			for (int j = 0; j < line.length(); j++) {
				matrix[i][j] = line.charAt(j);
			}
		}
		
		// Now is the beginning of the real algo...
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < cols; j++) {
				charCollector = new HashSet<>();
				DFS(i, j);
				
				if (charCollector.size() > 0) {
					areas++;
					Iterator<Character> currentCharIterator = charCollector.iterator();
					char currentChar = currentCharIterator.next();
					
					if (!result.containsKey(currentChar)) {
						result.put(currentChar, 0);
					}
					
					result.put(currentChar, result.get(currentChar) + 1);					
				}
			}
		}
		
		System.out.println("Areas: " + areas);
		
		for (Entry<Character, Integer> entry : result.entrySet()) {
			System.out.println("Letter \'" + entry.getKey() + "\' -> " + entry.getValue());
		}
	}
	
	public static void DFS(int row, int col) {
		if (!visited[row][col]) {
			visited[row][col] = true;
			
			if (col - 1 >= 0 && matrix[row][col] == matrix[row][col - 1]) {
				DFS(row, col -1);
			}
			
			if (col + 1 < cols && matrix[row][col] == matrix[row][col + 1]) {
				DFS(row, col + 1);
			}
			
			if (row + 1 < matrix.length && matrix[row][col] == matrix[row + 1][col]) {
				DFS(row + 1, col);
			}
			
			if (row - 1 >= 0 && matrix[row][col] == matrix[row - 1][col]) {
				DFS(row - 1, col);
			}
			
			charCollector.add(matrix[row][col]);
		}
	}

}
