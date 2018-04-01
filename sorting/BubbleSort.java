package sorting;

public class BubbleSort {

//  public static void main(String[] args) {
//    int[] numbersToSort = {98, 123, 254, 11, 1000, 1, 5, 9, 8, 9};
//    int[] sorted = sortWithBubbles(numbersToSort);
//    
//    for (int i = 0; i < sorted.length; i++) {
//      System.out.print(sorted[i] + " ");
//    }
//  }
  
  public static int[] sortWithBubbles(int[] arr) {
    boolean wereThereSwaps = true;
    
    while (wereThereSwaps) {
      wereThereSwaps = false;
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
          int temp = arr[i];
          arr[i] = arr[i - 1];
          arr[i - 1] = temp;
          wereThereSwaps = true;
        }
      }
    }
    
    return arr;
  }

}
