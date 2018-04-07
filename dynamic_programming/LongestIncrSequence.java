package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LongestIncrSequence {

  public static void maina(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] numsString = scanner.nextLine().split(" ");
    int[] nums = new int[numsString.length];
    
    for (int i = 0; i < numsString.length; i++) {
      nums[i] = Integer.parseInt(numsString[i]);
    }
    
    int[] seq = new int[nums.length];
    int[] prev = new int[nums.length];
    List<Integer> res = new ArrayList<Integer>();
    int lastElIdx = -1;
    int maxSeqValue = 1;
    
    for (int i = 0; i < prev.length; i++) {
      seq[i] = 1;
      prev[i] = -1;
      
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i] && seq[j] >= seq[i]) {
          seq[i] = seq[j] + 1;
          prev[i] = j;
          if (seq[i] > maxSeqValue) {
            maxSeqValue = seq[i];
            lastElIdx = i;
          }
        }
        
      }
    }

    System.out.println(maxSeqValue);
    while (lastElIdx != -1) {
      res.add(nums[lastElIdx]);
      lastElIdx = prev[lastElIdx];
    }
    Collections.reverse(res);
    for (Integer integer : res) {
      System.out.print(integer + " ");
    }
  }
}
