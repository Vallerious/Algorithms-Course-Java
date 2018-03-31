package recursion;

public class RecursiveCombinations {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] fillMe = new int[2];
//		int[] takeFromMe = {1, 2, 3, 4};
//		
//		generateCombinations(takeFromMe, fillMe, 0, 0);
//	}
	
	public static void generateCombinations(int[] set, int[] vector, int idx, int border) {
		if (idx > vector.length - 1) {
			printArray(vector);
			return;
		}
		
		for (int i = border; i < set.length; i++) {
			vector[idx] = set[i];
			generateCombinations(set, vector, idx + 1, i + 1);
		}
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
