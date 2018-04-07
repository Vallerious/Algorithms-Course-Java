package solving;

import java.util.Scanner;

public class KefaAndFirstSteps {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int len = Integer.parseInt(scanner.nextLine());
    int[] nums = stringToIntArray(scanner.nextLine().split(" "));
    scanner = null;
    int maxLen = 1;
    int[] seq = new int[nums.length];
    seq[0] = 1;
    
    for (int i = 1; i < seq.length; i++) {
      seq[i] = 1;
      if (nums[i] >= nums[i - 1]) {
        seq[i] = seq[i - 1] + 1;
        
        if (maxLen < seq[i]) {
          maxLen = seq[i];
        }
      }
    }
    
    System.out.println(maxLen);
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
