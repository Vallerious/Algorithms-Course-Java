package recursion;

public class GenerateVector {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] archo = new int[5];
//		generateVector(archo, 0);
//	}
	
	public static void generateVector(int[] arr, int idx) {
		if (idx > arr.length - 1) {
			printArray(arr);
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			arr[idx] = i;
			generateVector(arr, idx + 1);
		}
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
