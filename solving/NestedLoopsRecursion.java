package solving;

public class NestedLoopsRecursion {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] nums = new int[4];
//		nestedLoops(nums, 0);
//	}
	
	public static void nestedLoops(int[] nums, int idx) {
		if (nums.length <= idx) {
			print(nums);
			return;
		}
		
		for (int i = 1; i <= nums.length; i++) {
			nums[idx] = i;
			nestedLoops(nums, idx + 1);
		}
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
