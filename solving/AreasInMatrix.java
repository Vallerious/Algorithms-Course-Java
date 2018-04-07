package solving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AreasInMatrix {
	
	public static Map<Integer, Integer> sizeMap = new HashMap<>();

	public static void mains(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {
				{'*', '-', '-', '*', '-', '-', '-', '*', '-', '-'},
				{'*', '-', '-', '*', '-', '-', '-', '*', '-', '-'},
				{'*', '-', '-', '*', '*', '*', '*', '*', '-', '-'},
				{'*', '-', '-', '*', '-', '-', '-', '*', '-', '-'},
				{'*', '-', '-', '*', '-', '-', '-', '*', '-', '-'},
		};
		
		List<HashSet<String>> result = getAreasInMatrix(matrix, 5, 10);
		System.out.println("Total areas found: " + result.size());
		
		
		int idx = 1;

		for(HashSet<String> set : result) {
			System.out.println("Area {" + idx + "} size: " + set.size());
			idx++;
		}
	}
	
	public static List<HashSet<String>> getAreasInMatrix(char[][] m, int rows, int cols) {
		List<HashSet<String>> areas = new ArrayList<HashSet<String>>();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (m[i][j] == '*') continue; 
				int existingAreaIdx = checkIfAreaExists(areas, i, j);
				if (existingAreaIdx > -1) {
					// add these coords to the areas
					areas.get(existingAreaIdx).add(i + " " + j);
				} else {
					// create a new entry in the list
					HashSet<String> newHashSet = new HashSet<String>();
					newHashSet.add(i + " " + j);
					areas.add(newHashSet);
				}
			}
		}
		
		return areas;
	}
	
	public static int checkIfAreaExists(List<HashSet<String>> setList, int rowCoord, int colCoord) {
		if (setList.size() == 0) return -1;
		int idx = 0;
		
		for (HashSet<String> set : setList) {
			if (checkForNeighbours(set, rowCoord, colCoord)) {
				return idx;
			}
			idx++;
		}
		
		return -1;
	}
	
	public static boolean checkForNeighbours(HashSet<String> set, int rowCoord, int colCoord) {
		String topNeighbour = (rowCoord - 1) + " " + colCoord;
		if (set.contains(topNeighbour)) return true;
		String rightNeighbour = rowCoord + " " + (colCoord + 1);
		if (set.contains(rightNeighbour)) return true;
		int nextNeighbourRowCoord = rowCoord;
		int nextNeighbourColCoord = colCoord + 1;
		String nextNeighbourTopNeighbour = (nextNeighbourRowCoord - 1) + " " + nextNeighbourColCoord;
		if (set.contains(nextNeighbourTopNeighbour)) return true;
		String bottomNeighbour = (rowCoord + 1) + " " + colCoord;
		if (set.contains(bottomNeighbour)) return true;
		String leftNeighbour = rowCoord + " " + (colCoord - 1);
		if (set.contains(leftNeighbour)) return true;
		
		return false;
	}

}
