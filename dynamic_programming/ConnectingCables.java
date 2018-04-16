package dynamic_programming;

public class ConnectingCables {

  public static void main(String[] args) {
    int[] permutedCables = {2, 5, 3, 8, 7, 4, 6, 9, 1};
    int[] sequencedCables = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int len = permutedCables.length;
    int[][] field = new int[len][len];
    
    for (int colIdx = 0; colIdx < len; colIdx++) {
      if (permutedCables[0] == sequencedCables[colIdx]) {
        field[0][colIdx] = 1;
      }
    }
    
    for (int rowIdx = 0; rowIdx < len; rowIdx++) {
      if (sequencedCables[0] == permutedCables[rowIdx]) {
        field[rowIdx][0] = 1;
      }
    }
    
    for (int rowIdx = 1; rowIdx < len; rowIdx++) {
      for (int colIdx = 1; colIdx < len; colIdx++) {
        int value = Math.max(field[rowIdx - 1][colIdx], field[rowIdx][colIdx - 1]);
        
        if (sequencedCables[colIdx] == permutedCables[rowIdx]) {
          field[rowIdx][colIdx] = field[rowIdx - 1][colIdx - 1] + 1;
        } else {
          field[rowIdx][colIdx] = value;
        }
      }
    }
    
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        System.out.print(field[i][j] + " ");
      }
      
      System.out.println();
    }
    
    System.out.println(field[len - 1][len - 1]);
  }

}
