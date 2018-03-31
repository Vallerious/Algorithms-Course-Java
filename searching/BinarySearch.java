package searching;

import java.util.Scanner;

public class BinarySearch {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
//		String[] input = s.nextLine().split(" ");
//		int[] numbers = new int[input.length];
//		
//		for (int i = 0; i < numbers.length; i++) {
//			numbers[i] = Integer.parseInt(input[i]);
//		}
//		
//		
//		
//		int idx = binarySearch(numbers, 0, numbers.length, s.nextInt());
//		System.out.println(idx);
//	}

	private static int binarySearch(int[] numbers, int startIdx, int endIdx, int lookUpInt) {
		if (endIdx >= 1) {
			if (startIdx >= endIdx) {
				return -1;
			}
			int mid = (startIdx + endIdx) / 2;
			if (numbers[mid] == lookUpInt) {
				return mid;
			} else if (numbers[mid] < lookUpInt) {
				return binarySearch(numbers, mid + 1, endIdx, lookUpInt);
			} else if (numbers[mid] > lookUpInt) {
				return binarySearch(numbers, startIdx, mid, lookUpInt);
			} else {
				return -1;
			}			
		} else {
			return -1;
		}
	}

}
