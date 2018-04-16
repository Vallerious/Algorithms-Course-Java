package solving;

import java.util.Scanner;

public class CFSolutions {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    String[] numberStrs = scanner.nextLine().split(" ");
    int[] numbers = new int[n];
    
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(numberStrs[i]);
    }
    
    int maxValueIdx = -1;
    int maxVal = -1;
    
    int minValueIdx = -1;
    int minValue = Integer.MAX_VALUE;
    
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > maxVal) {
        maxVal = numbers[i];
        maxValueIdx = i;
      }
      
      if (numbers[i] <= minValue) {
        minValue = numbers[i];
        minValueIdx = i;
      }
    }
    
    if (maxValueIdx > minValueIdx) {
      minValueIdx++;
    }
    
    
    
    int stepsToMoveMaxToFirstPos = maxValueIdx;
    int stepsToMoveMinToFirstPos = n - minValueIdx - 1;
    
    System.out.println(stepsToMoveMaxToFirstPos + stepsToMoveMinToFirstPos);
  }

}
