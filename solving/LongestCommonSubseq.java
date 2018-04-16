package solving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubseq {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] wordOne = scanner.nextLine().split("");
    String[] wordTwo = scanner.nextLine().split("");
    
    int[][] field = new int[wordOne.length + 1][wordTwo.length + 1];
    
    for (int wordOneIdx = 0; wordOneIdx < wordOne.length; wordOneIdx++) {
      int rowIdx = wordOneIdx + 1;
      
      for (int wordTwoIdx = 0; wordTwoIdx < wordTwo.length; wordTwoIdx++) {
        int colIdx = wordTwoIdx + 1;
        
        if (wordOne[wordOneIdx].equals(wordTwo[wordTwoIdx])) {
          field[rowIdx][colIdx] = field[rowIdx - 1][colIdx - 1] + 1;
        } else {
          field[rowIdx][colIdx] = Integer.max(field[rowIdx - 1][colIdx], field[rowIdx][colIdx - 1]);
        }
      }
    }
    
    System.out.println(field[wordOne.length][wordTwo.length]);
    
//    ArrayList<String> result = new ArrayList<>();
//    
//    int currentRow = wordOne.length;
//    int currentCol = wordTwo.length;
    
//    while (currentCol > 0 && currentRow > 0) {
//      if (wordOne[currentRow - 1].equals(wordTwo[currentCol - 1])) {
//        result.add(wordOne[currentRow - 1]);
//        currentCol--;
//        currentRow--;
//      } else if (field[currentRow - 1][currentCol] == field[currentRow][currentCol]) {
//        currentRow--;
//      } else {
//        currentCol--;
//      }
//      
//    }
//    result.forEach(ch -> System.out.print(ch));
  }

}
