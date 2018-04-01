package sorting;

import java.util.Scanner;

public class QuickSort {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    String[] cmdLineParams = scanner.nextLine().split(" ");
    int len = cmdLineParams.length;
    int[] numbersToSort = new int[len];
    
    for (int i = 0; i < len; i++) {
      numbersToSort[i] = Integer.parseInt(cmdLineParams[i]);
    }
    
    quickSort(numbersToSort, 0, len - 1);
    
    for (int i = 0; i < len; i++) {
      System.out.print(numbersToSort[i] + " ");
    }
  }
  
  public static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int pi = partition(arr, start, end);
      
      quickSort(arr, start, pi - 1);
      quickSort(arr, pi + 1, end);
    }
  }

  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int smallerIdx = start - 1;
    
    for (int i = start; i <= end - 1; i++) {
      if (arr[i] < pivot) {
        smallerIdx++;
        int temp = arr[i];
        arr[i] = arr[smallerIdx];
        arr[smallerIdx] = temp;
      }
    }
    
    int temp = arr[smallerIdx + 1];
    arr[smallerIdx + 1] = pivot;
    arr[end] = temp;
    
    return smallerIdx + 1;
  }
}
