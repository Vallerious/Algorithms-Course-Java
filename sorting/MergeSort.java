package sorting;

import java.util.Scanner;

public class MergeSort {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    String[] cmdLineParams = scanner.nextLine().split(" ");
    int[] numbersToSort = new int[cmdLineParams.length];
    
    for (int i = 0; i < numbersToSort.length; i++) {
      numbersToSort[i] = Integer.parseInt(cmdLineParams[i]);
    }
    
    mergeSort(numbersToSort, 0, numbersToSort.length - 1);
    
    for (int i = 0; i < numbersToSort.length; i++) {
      System.out.print(numbersToSort[i] + " ");
    }
  }
  
  public static void mergeSort(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    
    int mid = (end + start) / 2;
    
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    merge(arr, start, mid, end);
  }
  
  public static void merge(int[] arr, int left, int mid, int right) {
    if (left >= right) {
      return;
    }
    
    int leftIdx = left;
    int rightIdx = mid + 1;
    int helperArrLength = ((mid - left) + 1) + ((right - (mid + 1)) + 1); 
    int[] helper = new int[helperArrLength];
    int helperIdx = 0;
    
    while (leftIdx <= mid && rightIdx <= right) {
      if (arr[leftIdx] < arr[rightIdx]) {
        helper[helperIdx++] = arr[leftIdx++];
      }
      
      if (arr[rightIdx] < arr[leftIdx]) {
        helper[helperIdx++] = arr[rightIdx++];
      }
    }
    
    while (leftIdx <= mid) {
      helper[helperIdx++] = arr[leftIdx++];
    }
    
    while (rightIdx <= right) {
      helper[helperIdx++] = arr[rightIdx++];
    }
    
    System.arraycopy(helper, 0, arr, left, helper.length);
  }
}
