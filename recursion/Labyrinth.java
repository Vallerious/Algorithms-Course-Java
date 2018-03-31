package recursion;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {
	static int rows = 3;
	static int cols = 5;
	static char[][] lab = {
			{'-', '*', '*', '-', 'e'},
			{'-', '-', '-', '-', '-'},
			{'*', '*', '*', '*', '*'},
	};
	static boolean[][] visited = new boolean[rows][cols];
	static List path = new ArrayList();
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		findPaths(0, 0, 'S');
//	}
	
	public static void findPaths(int row, int col, char dir) {
		if (!isInBounds(row, col)) return;
		
		path.add(dir);
		
		if (isExit(row, col)) {
			printPath();
		} else if (!isVisited(row, col) && isFree(row, col)) {
			mark(row, col);
			findPaths(row, col + 1, 'R');
			findPaths(row + 1, col, 'D');
			findPaths(row, col - 1, 'L');
			findPaths(row - 1, col, 'U');
			unmark(row, col);
		}
		
		path.remove(path.size() - 1);
		
		
	}
	
	public static boolean isInBounds(int row, int col) {
		return !(row >= rows || col >= cols || row < 0 || col < 0);
	}
	
	public static void printPath() {
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i));
		}
		System.out.println();
	}
	
	public static boolean isExit(int row, int col) {
		return lab[row][col] == 'e';
	}
	
	public static boolean isFree(int row, int col) {
		return lab[row][col] == 'e' || lab[row][col] == '-';
	}
	
	public static boolean isVisited(int row, int col) {
		return visited[row][col];
	}
	
	public static void mark(int row, int col) {
		visited[row][col] = true;
	}
	
	public static void unmark(int row, int col) {
		visited[row][col] = false;
	}

}
