package dynamic_programming;

import java.util.HashSet;

public class FindSubsum {

  public static void main(String[] args) {
    int[] numbers = {3, 5, 1, 4, 2};
    
    
  }
  
  public static HashSet<Integer> getAllPossibleSums(int[] nums) {
    HashSet<Integer> possibleSums = new HashSet<>();
    possibleSums.add(0);
    
    for (int i = 0; i < nums.length; i++) {
      HashSet<Integer> temp = new HashSet<>();
      
      for (Integer sum : possibleSums) {
        if (!temp.contains(sum)) {
          
        }
      }
    }
    
    return possibleSums;
  }

}
