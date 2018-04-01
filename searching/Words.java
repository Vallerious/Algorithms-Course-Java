package searching;

import java.util.Arrays;

public class Words {
  static String[] chars = "aahhhaa".split("");

//  public static void main(String[] args) {
//    // TODO Auto-generated method stub
//    int n = 7;
//    int[] numbers = new int[n];
//    
//    generateCombinationsWithRepetition(numbers, 0, 0, 6);
//  }
  
  public static void generateCombinationsWithRepetition(int[] arr, int idx, int currNumber, int choiceCount) {
    if (arr.length <= idx) {
        print(arr);
        return;
    }
    
    for (int i = currNumber; i <= choiceCount; i++) {
        arr[idx] = i;
        generateCombinationsWithRepetition(arr, idx + 1, i, choiceCount);
    }
  }
  
  public static void print(int[] arr) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      builder.append(chars[arr[i]]);        
    }
//    if (builder.toString().equals("ahahaha")) {
      System.out.println(builder.toString());
//    }
  }

}
