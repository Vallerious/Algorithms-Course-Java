package solving;

import java.util.Arrays;
import java.util.Scanner;

public class Puzzles {

  public static void maink(String[] args) {
    Scanner s = new Scanner(System.in);
    String[] lp1 = s.nextLine().split(" ");
    int studCount = Integer.parseInt(lp1[0]);
    lp1 = null;
    int[] puzzlesSize = stringToIntArray(s.nextLine().split(" "));
    s = null;
    
    int res = findMinDiff(puzzlesSize, studCount);
    
    System.out.println(res);
  }
  
  /*
   * Works for sorted arrays.
   */
  public static int findMinDiff(int[] arr, int gap) {
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    
    for (int i = arr.length - 1; i >= gap - 1; i--) {
      int diff = arr[i] - arr[i - gap + 1];

      if (diff < minDiff) {
        minDiff = diff;
      }
    }
    
    return minDiff;
  }
  
  public static int[] stringToIntArray(String[] stringArray) {
    int len = stringArray.length;
    int[] intArray = new int[len];
    
    for (int i = 0; i < len; i++) {
      try {
        intArray[i] = Integer.parseInt(stringArray[i]);        
      } catch (NumberFormatException e) {
        return intArray;
      }
    }
    
    return intArray;
  }

}
