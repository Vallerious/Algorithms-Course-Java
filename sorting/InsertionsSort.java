package sorting;

public class InsertionsSort {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] numbersToSort = {19, 20, 3, 11, 90, 1, 2};
    
    int[] sorted = sortThatArrayWithInsertion(numbersToSort);
    
    for (int i = 0; i < sorted.length; i++) {
      System.out.print(sorted[i] + " ");
    }
  }
  
  public static int[] sortThatArrayWithInsertion(int[] arr) {
    for (int currentEl = 1; currentEl < arr.length; currentEl++) {
      int idx = -1;
      for (int i = 0; i < currentEl; i++) {
        if (arr[i] > arr[currentEl]) {
          idx = i;
          
          for (int j = currentEl; j > idx; j--) {
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
          }
        }
      }
    }
    
    return arr;
  }

}
