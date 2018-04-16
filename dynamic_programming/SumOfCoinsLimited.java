package dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfCoinsLimited {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] numberstr = scanner.nextLine().split(" ");
    int[] nums = new int[numberstr.length];
    
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(numberstr[i]);
    }
    
    int targetsum = scanner.nextInt();
    
    Map<Integer, Integer> sums = new HashMap<>();
    Map<Integer, Integer> sumsCount = new HashMap<>();
    sums.put(0, 0);
    sumsCount.put(0, 1);
    
    for (int i = 0; i < nums.length; i++) {
      int currNum = nums[i];
      
      Map<Integer, Integer> temp = new HashMap<>();
      
      for (int sum : sums.keySet()) {
        int newSum = sum + currNum;
        if (!sumsCount.containsKey(newSum)) {
          sumsCount.put(newSum, 1);          
        }
//        if (!sums.containsKey(newSum)) {
          temp.put(newSum, currNum);
//        } else {
          sumsCount.put(newSum, sumsCount.get(newSum) + 1);
//        }
      }
      
      for (int sum : temp.keySet()) {
        sums.put(sum, temp.get(sum));
      }
    }
    
    System.out.println(sumsCount.get(targetsum));
    
  }

}
