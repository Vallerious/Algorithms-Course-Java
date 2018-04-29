package solving;

public class CombinationsWithoutRepetition {

	public static void main(String[] args) {
		int n = 2;
		int[] numbers = new int[n];
		
		generateCombinationsWithoutRep(numbers, 0, 0, 2);
	}
	
	public static void generateCombinationsWithoutRep(int[] nums, int idx, int start, int choiceCount) {
		if (nums.length <= idx) {
			print(nums);
			return;
		}
		
		for (int i = start; i <= choiceCount; i++) {
			nums[idx] = i;
			generateCombinationsWithoutRep(nums, idx + 1, i + 1, choiceCount);
		}
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
