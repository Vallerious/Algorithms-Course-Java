package recursion;

public class RecursiveSum {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		int[] arr = {-1, 2, 3, 4};
//		
//		System.out.println(sum(arr, 0));
//	}
	
	public static int sum(int[] array, int idx) {
		if (idx > array.length - 1) {
			return 0;
		}
		
		return array[idx] + sum(array, idx + 1);
	}

}
