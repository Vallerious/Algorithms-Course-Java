package exam_prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PathInMatrix {
  static int[][] matrix;
  static int[][] matrixZigZagSums;
  static int[][] prevRowIdxMatrix;
  static int maxValue = 0;
  static int rowCount = 0;
  static int colCount = 0;
  static int maxValueRow = -1;
  static List<Integer> results = new ArrayList<>();

  public static void main(String[] args) {
    takeInput();
    prefillZigZagSums();
    fillZigZagSums();
    findMaximumSum();
    traceBackThePath();
    displayResult();
  }
  
  static void displayResult() {
    Collections.reverse(results);
    StringBuilder stringBuilder = new StringBuilder();
    
    stringBuilder.append(maxValue + " = ");
    
    for (Integer num : results) {
      stringBuilder.append(num + " + ");
    }
    
    System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 3));
  }
  
  static void traceBackThePath() {
    int initialRowIdx = maxValueRow;

    for (int i = colCount - 1; i >= 0; i--) {
      results.add(matrix[initialRowIdx][i]);
      
      initialRowIdx = prevRowIdxMatrix[initialRowIdx][i];
    }
  }
  
  static void findMaximumSum() {
    int maxSum = Integer.MIN_VALUE;
    
    for (int i = 0; i < rowCount; i++) {
      if (matrixZigZagSums[i][colCount - 1] > maxSum) {
        maxSum = matrixZigZagSums[i][colCount - 1];
        maxValueRow = i;
      }
    }
    
    maxValue = maxSum;
  }
  
  static void prefillZigZagSums() {
    matrixZigZagSums = new int[rowCount][colCount];
    for (int i = 0; i < rowCount; i++) {
      matrixZigZagSums[i][0] = matrix[i][0];
    }
    
    for (int i = 0; i < colCount; i++) {
      matrixZigZagSums[0][i] = matrix[0][i];
    }
  }
  
  static void fillZigZagSums() {
    prevRowIdxMatrix = new int[rowCount][colCount];
    for (int colIdx = 1; colIdx < colCount; colIdx++) {
      for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
        if (colIdx % 2 != 0) {
          // Look down (row - 1) and in col - 1
          int startingRowIdx = rowIdx + 1;
          int startingColIDx = colIdx - 1;
          int maxValue = Integer.MIN_VALUE;
          int maxValueRowIdx = -1;

          while (startingRowIdx < rowCount) {
            int currentLeftNum = matrixZigZagSums[startingRowIdx][startingColIDx];
            
            if (currentLeftNum > maxValue) {
              maxValue = currentLeftNum;
              maxValueRowIdx = startingRowIdx;
            }
            
            startingRowIdx++;
          }
          
          matrixZigZagSums[rowIdx][colIdx] = maxValue + matrix[rowIdx][colIdx];
          prevRowIdxMatrix[rowIdx][colIdx] = maxValueRowIdx;
        } else {
          // Look up (row + 1) and col + 1
          int startingRowIdx = rowIdx - 1;
          int startingColIDx = colIdx - 1;
          int maxValue = Integer.MIN_VALUE;
          int maxValueRowIdx = -1;

          while (startingRowIdx >= 0) {
            int currentLeftNum = matrixZigZagSums[startingRowIdx][startingColIDx];
            
            if (currentLeftNum > maxValue) {
              maxValue = currentLeftNum;
              maxValueRowIdx = startingRowIdx;
            }
            
            startingRowIdx--;
          }
          
          matrixZigZagSums[rowIdx][colIdx] = maxValue + matrix[rowIdx][colIdx];
          prevRowIdxMatrix[rowIdx][colIdx] = maxValueRowIdx;
        }
      }
    }
  }
  
  static void takeInput() {
    Scanner scanner = new Scanner(System.in);
    rowCount = Integer.parseInt(scanner.nextLine());
    colCount = Integer.parseInt(scanner.nextLine());
    matrix = new int[rowCount][];
    for (int i = 0; i < rowCount; i++) {
      String[] line = scanner.nextLine().split(",");
      matrix[i] = new int[colCount];
      for (int j = 0; j < colCount; j++) {
        matrix[i][j] = Integer.parseInt(line[j]);
      }
    }
  }

}
