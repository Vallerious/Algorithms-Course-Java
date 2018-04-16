package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongestZigZagSeq {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] numberstr = scanner.nextLine().split(" ");
    int[] numbers = new int[numberstr.length];
    
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(numberstr[i]);
    }
    
    int[][] seq = new int[2][numbers.length];
    int[][] prev = new int[2][numbers.length];
    int maxValue = 0;
    int maxValIdx = -1;
    int bestSolutionArray = 0;
    seq[0][0] = 1;
    seq[1][0] = 1;
    prev[0][0] = prev[1][0] = -1;
    
    for (int currentIdx = 1; currentIdx < numbers.length; currentIdx++) {
      for (int prevIndex = 0; prevIndex < currentIdx; prevIndex++) {
        int currentNumber = numbers[currentIdx];
        int prevNumber = numbers[prevIndex];
        
        if (numbers[prevIndex] < numbers[currentIdx] && seq[0][currentIdx] < seq[1][prevIndex] + 1) {
          seq[0][currentIdx] = seq[1][prevIndex] + 1;
          prev[0][currentIdx] = prevIndex;
        }
        
        if (numbers[prevIndex] > numbers[currentIdx] && seq[1][currentIdx] < seq[0][prevIndex] + 1) {
          seq[1][currentIdx] = seq[0][prevIndex] + 1;
          prev[1][currentIdx] = prevIndex;
        }
      }
      
      if (seq[0][currentIdx] > maxValue) {
        maxValue = seq[0][currentIdx];
        bestSolutionArray = 0;
        maxValIdx = currentIdx;
      }
      
      if (seq[1][currentIdx] > maxValue) {
        maxValue = seq[1][currentIdx];
        bestSolutionArray = 1;
        maxValIdx = currentIdx;
      }
    }
    
    ArrayList<Integer> res = new ArrayList<>();
    
    while (maxValIdx > -1) {
      res.add(numbers[maxValIdx]);
      
      maxValIdx = prev[bestSolutionArray][maxValIdx];
      
      if (bestSolutionArray == 1) {
        bestSolutionArray = 0;
      } else {
        bestSolutionArray = 1;
      }
    }
    Collections.reverse(res);
    for (Integer integer : res) {
      System.out.print(integer + " ");
    }
  }

}
