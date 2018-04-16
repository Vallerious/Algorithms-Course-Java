package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class DividingPresents {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] numberstr = scanner.nextLine().split(" ");
    int[] nums = new int[numberstr.length];
    
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(numberstr[i]);
    }
    
    Map<Integer, Integer> sums = new HashMap<>();
    int totalSum = 0;
    sums.put(0, 0);
    
    for (int i = 0; i < nums.length; i++) {
      int currNum = nums[i];
      totalSum += currNum;
      
      Map<Integer, Integer> temp = new HashMap<>();
      
      for (int sum : sums.keySet()) {
        int newSum = sum + currNum;
        
        if (!sums.containsKey(newSum)) {
          temp.put(newSum, currNum);
        }
      }
      
      for (int sum : temp.keySet()) {
        sums.put(sum, temp.get(sum));
      }
    }
    int totalPresentsSum = totalSum;
    int targetSum = totalSum / 2;
    ArrayList<Integer> res = new ArrayList<>();
    
    while (!sums.containsKey(targetSum)) {
      targetSum--;
    }
    int alanShare = targetSum;
    int bobsShare = totalPresentsSum - targetSum;
    
    while (targetSum > 0 && sums.containsKey(targetSum)) {
      int prev = sums.get(targetSum);
      res.add(prev);
      targetSum -= sums.get(targetSum);
    }
    
    System.out.println("Difference: " + (bobsShare - alanShare));
    System.out.println("Alan:" + alanShare + " Bob:" + bobsShare);
    
    System.out.print("Alan takes: ");
    for (Integer integer : res) {
      System.out.print(integer + " ");
    }
    
    System.out.println();
    
    System.out.println("Bob takes the rest.");

  }

}
