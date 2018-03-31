package solving;

public class ReversePrintRecursion {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] arr = {1, 2, 3, 4, 5};
//		
//		reversePrint(arr, arr.length - 1);
//	}
	
	public static void reversePrint(int[] numbers, int idx) {
		if (idx < 0) {
			return;
		}
		
		System.out.print(numbers[idx] + " ");
		idx--;
		reversePrint(numbers, idx);
	}

}
