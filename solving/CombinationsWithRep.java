package solving;

public class CombinationsWithRep {

	public static void main(String[] args) {
		int n = 3;
		int[] result = new int[n];
		
		generateCombinationsWithoutRepetition(result, 0, 1, 3);
	}
	
	public static void generateCombinationsWithoutRepetition(int[] arr, int idx, int currNumber, int choiceCount) {
		if (arr.length <= idx) {
			print(arr);
			return;
		}
		
		for (int i = currNumber; i <= choiceCount; i++) {
			arr[idx] = i;
			generateCombinationsWithoutRepetition(arr, idx + 1, i, choiceCount);
		}
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
