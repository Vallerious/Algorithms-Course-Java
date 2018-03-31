package sorting;

import java.util.Scanner;

import javax.swing.text.Highlighter.Highlight;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String[] input = s.nextLine().split(" ");
		int[] numbers = new int[input.length];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		quickSort(numbers, 0, numbers.length - 1);
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
	
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					
					for (int k = i; k > j; k--) {
						arr[k] = arr[k - 1];
					}
					
					arr[j] = temp;
					break;
				}
			}
		}
	}
	
	public static void bubbleSort(int[] arr) {
		boolean wereThereAnySwaps = true;
		
		while (wereThereAnySwaps) {
			wereThereAnySwaps = false;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] < arr[i - 1]) {
					int t = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = t;
					wereThereAnySwaps = true;
				}
			}
		}
	}
	
	public static void mergeSort(int[] arr, int startIdx, int endIdx) {
		if (startIdx >= endIdx) {
			return;
		}
		int mid = (startIdx + endIdx) / 2;
		mergeSort(arr, startIdx, mid);
		mergeSort(arr, mid + 1, endIdx);
		merge(arr, startIdx, mid, endIdx);
	}

	private static void merge(int[] arr, int startIdx, int mid, int endIdx) {
		// TODO Auto-generated method stub
		if (startIdx < 0 || endIdx > arr.length - 1 || arr[mid] < arr[mid + 1]) return;
		
		int[] helper = new int[arr.length];
		
		for (int i = startIdx; i <= endIdx; i++) {
			helper[i] = arr[i];
		}
		
		int leftIdx = startIdx;
		int rightIdx = mid + 1;
		
		for (int i = startIdx; i <= endIdx; i++) {
			if (leftIdx > mid) {
				arr[i] = helper[rightIdx++];
			} else if (rightIdx > endIdx) {
				arr[i] = helper[leftIdx++];
			} else if (helper[leftIdx] < helper[rightIdx]) {
				arr[i] = helper[leftIdx++];
			} else {
				arr[i] = helper[rightIdx++];
			}
		}
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		} else {
			return;
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		
		int t = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = t;
		
		return i + 1;
	}

}
