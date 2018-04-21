package dynamic_programming;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class MinimumEditDistance {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    int costReplace = Integer.parseInt(scanner.nextLine().split("=")[1].trim());
    int costInsert = Integer.parseInt(scanner.nextLine().split("=")[1].trim());
    int costDelete = Integer.parseInt(scanner.nextLine().split("=")[1].trim());
    String[] s1 = scanner.nextLine().split("=")[1].trim().split("");
    String[] s2 = scanner.nextLine().split("=")[1].trim().split("");
    
    int[][] matrix = new int[s1.length + 1][s2.length + 1];
    
    matrix[0][0] = 0;
    
    for (int colIdx = 1; colIdx < s2.length + 1; colIdx++) {
      matrix[0][colIdx] = matrix[0][colIdx - 1] + costInsert;
    }
    
    for (int rowIdx = 1; rowIdx < s1.length + 1; rowIdx++) {
      matrix[rowIdx][0] = matrix[rowIdx - 1][0] + costDelete;
    }
    
    for (int rowIdx = 1; rowIdx < s1.length + 1; rowIdx++) {
      for (int colIdx = 1; colIdx < s2.length + 1; colIdx++) {
        if (s1[rowIdx - 1].equals(s2[colIdx - 1])) {
          matrix[rowIdx][colIdx] = matrix[rowIdx - 1][colIdx - 1];
        } else {
          int insert = matrix[rowIdx][colIdx - 1] + costInsert;
          int delete = matrix[rowIdx - 1][colIdx] + costDelete;
          int replace = matrix[rowIdx - 1][colIdx - 1] + costReplace;
          
          matrix[rowIdx][colIdx] = Math.min(insert, Math.min(delete, replace));
        }
      }
    }
    
    Stack<String> result = new Stack<>();
    
    int rowIdx = s1.length;
    int colIdx = s2.length;
    
    while (rowIdx > 0 && colIdx > 0) {
      if (s1[rowIdx - 1].equals(s2[colIdx - 1])) {
        rowIdx--;
        colIdx--;
      } else {
        int insert = matrix[rowIdx][colIdx - 1] + costInsert;
        int delete = matrix[rowIdx - 1][colIdx] + costDelete;
        int replace = matrix[rowIdx - 1][colIdx - 1] + costReplace;
        
        if (replace <= delete && replace <= insert) {
          result.push("REPLACE(" + (rowIdx - 1) + ", " + s2[colIdx - 1] + ")");
          rowIdx--;
          colIdx--;
        } else if (delete < insert && delete < replace) {
          result.push("DELETE(" + (rowIdx - 1) + ")");
          rowIdx--;
        } else {
          result.push("INSERT(" + (colIdx - 1) + ", " + s2[colIdx - 1] + ")");
          colIdx--;
        }
      }
    }
    
    while (rowIdx > 0) {
      result.push("DELETE(" + (rowIdx - 1) + ")");
      rowIdx--;
    }
    
    while (colIdx > 0) {
      result.push("INSERT(" + (colIdx - 1) + ", " + s2[colIdx - 1] + ")");
      colIdx--;
    }
    
    System.out.println("Minimum edit distance: " + result.size());
    
    while (result.size() > 0) {
      System.out.println(result.pop());
    }
  }

}
