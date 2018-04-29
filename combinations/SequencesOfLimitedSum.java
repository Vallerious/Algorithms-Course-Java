package combinations;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SequencesOfLimitedSum {
  static int n;
  static Set<String> results = new TreeSet<>();
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = Integer.parseInt(scanner.nextLine());
    int[] result = new int[n];

    generateCombinationsWithoutRepetition(result, 0, 0, n);
    
    for (String i : results) {
      System.out.println(i);
    }
  }

  public static void generateCombinationsWithoutRepetition(int[] arr, int idx, int currNumber, int choiceCount) {
    if (arr.length <= idx) {
      int sum = sum(arr);
      
      if (sum <= n) {
        String arrStr = arrToString(arr);
        
        if (arrStr.length() > 0) {
          results.add(arrToString(arr));          
        }
      }
      return;
    }

    for (int i = currNumber; i <= choiceCount; i++) {
      arr[idx] = i;
      generateCombinationsWithoutRepetition(arr, idx + 1, i, choiceCount);
    }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
  
  static int sum(int[] arr) {
    int sum = 0;
    
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    
    return sum;
  }
  
  static String arrToString(int[] arr) {
    StringBuilder stringBuilder = new StringBuilder(arr.length);
    
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        stringBuilder.append(arr[i] + " ");
      }
    }
    
    return stringBuilder.toString().trim();
  }

}
