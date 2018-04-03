package greedy;

import javax.swing.RowFilter;

public class KnightsTour {
  static int minValue = Integer.MAX_VALUE;
  static int minRowIdx = -1;
  static int minColIdx = -1;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // Hmmmm I think I have to eat more turnip to solve that one
    int n = 6;
    int[][] field = new int[n][n];
    int step = 1;
    int currentRow = 0;
    int currentCol = 0;
    field[currentRow][currentCol] = step++;
    
    while (step <= 25) {
      // position 1
      int[] positions = new int[8];
      positions[0] = getPositionValue(field, currentRow - 1, currentCol + 2);
      positions[1] = getPositionValue(field, currentRow + 1, currentCol + 2);
      positions[2] = getPositionValue(field, currentRow + 2, currentCol + 1);
      positions[3] = getPositionValue(field, currentRow + 2, currentCol - 1);
      positions[4] = getPositionValue(field, currentRow + 1, currentCol - 2);
      positions[5] = getPositionValue(field, currentRow - 1, currentCol - 2);
      positions[6] = getPositionValue(field, currentRow - 2, currentCol - 1);
      positions[7] = getPositionValue(field, currentRow - 2, currentCol + 1);
      
      field[minRowIdx][minColIdx] = step++;
      currentRow = minRowIdx;
      currentCol = minColIdx;
      minValue = Integer.MAX_VALUE;
      minRowIdx = -1;
      minColIdx = -1;
     }
    
    System.out.println();
  }

  private static int getPositionValue(int[][] field, int i, int j) {
    if (isOkayToPutMyHorseThere(field, i, j)) {
      int score = 0;
      
      if (isOkayToPutMyHorseThere(field, i - 1, j + 2)) {
        score++;
      }
      
      if (isOkayToPutMyHorseThere(field, i + 1, j + 2)) {
        score++;
      }
      
      if (isOkayToPutMyHorseThere(field, i + 2, j + 1)) {
        score++;
      }
      
      if (isOkayToPutMyHorseThere(field, i + 2, j - 1)) {
        score++;
      }
      
      if (isOkayToPutMyHorseThere(field, i + 1, j - 2)) {
        score++;
      }
      
      if (isOkayToPutMyHorseThere(field, i - 1, j - 2)) {
        score++;
      }
      
      if (isOkayToPutMyHorseThere(field, i - 2, j - 1)) {
        score++;
      }
      
      if (isOkayToPutMyHorseThere(field, i - 2, j + 1)) {
        score++;
      }
      
      if (score < minValue) {
        minValue = score;
        minRowIdx = i;
        minColIdx = j;
      }
      
      return score;
    } else {
      return Integer.MAX_VALUE;
    }
  }

  private static boolean isOkayToPutMyHorseThere(int[][] field, int currentRow, int currentCol) {
    return isFree(field, currentRow, currentCol) && isInFieldRange(field.length, currentRow, currentCol);
  }

  private static boolean isInFieldRange(int length, int currentRow, int currentCol) {
    return (currentRow >= 0) && (currentCol >= 0) && currentRow < length && currentCol < length;
  }

  private static boolean isFree(int[][] field, int currentRow, int currentCol) {
    return isInFieldRange(field.length, currentRow, currentCol) && field[currentRow][currentCol] == 0;
  }

}
