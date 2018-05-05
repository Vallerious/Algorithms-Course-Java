package exam_prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Elections {
  static int majorityPartiesCount = 0;
  public static void main(String[] args) throws NumberFormatException, IOException {
    // This is basically a subset of sums algorithm. After having all the possible sums we count the ones that are above K.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int targetSum = Integer.parseInt(br.readLine());
    int partiesCount = Integer.parseInt(br.readLine());
    int[] nums = new int[partiesCount];
    
    for (int i = 0; i < partiesCount; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }
    
    calcPossibleSums(nums, targetSum);
    
    System.out.println(majorityPartiesCount);
  }
  
  static List<Integer> calcPossibleSums(int[] numbers, int target) {
    List<Integer> sums = new ArrayList<>();
    sums.add(0);
    
    for (int i = 0; i < numbers.length; i++) {
      List<Integer> intermediateSet = new ArrayList<>();
      
      for (Integer sum : sums) {
        int newSum = sum + numbers[i];
        intermediateSet.add(newSum);
        
        if (newSum >= target) {
          majorityPartiesCount++;
        }
      }
      
      sums.addAll(intermediateSet);
    }
    
    return sums;
  }

}
