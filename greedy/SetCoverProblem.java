package greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetCoverProblem {
  public static HashSet<Integer> universe = new HashSet<>();
  public static int[] arrayLikeUniverse = {1, 2, 3, 4, 5};
  public static int[][] sets = {
      {1, 2, 3, 4, 5},
      {2, 3, 4, 5},
      {5},
      {3}
  };
  public static List<int[]> setsTaken = new ArrayList<>();
  public static int setsTakenCount = 0;
  
//  public static void main(String[] args) {
//    quickSort(0, sets.length - 1);
//    pluckUniverseInSet();
//    takeFromSets();
//    
//    System.out.println("Sets to take (" + setsTakenCount + "):");
//    
//    for (int i = 0; i < setsTaken.size(); i++) {
//      System.out.print("{ ");
//      
//      for (int j = 0; j < setsTaken.get(i).length; j++) {
//        System.out.print(setsTaken.get(i)[j] + " ");
//      }
//      
//      System.out.print("}");
//      System.out.println();
//    }
//  }
  
  public static void takeFromSets() {
    for (int i = sets.length - 1; i >= 0; i--) {
      if (universe.size() == 0) {
        break;
      }
      // Starting from the largest set
      int[] currentSet = sets[i];
      boolean isTaken = false;
      
      for (int j = 0; j < currentSet.length; j++) {
        if (universe.contains(currentSet[j])) {
          universe.remove(currentSet[j]);
          isTaken = true;
        }
      }
      

      if (isTaken) {
        setsTaken.add(currentSet);
        setsTakenCount++;
      }
    }
  }
  
  public static void pluckUniverseInSet() {
    for (int i = 0; i < arrayLikeUniverse.length; i++) {
      universe.add(arrayLikeUniverse[i]);
    }
  }
  
  public static void quickSort(int start, int end) {
    if (start < end) {
      int pi = partition(start, end);
      
      quickSort(start, pi - 1);
      quickSort(pi + 1, end);
    }
  }

  private static int partition(int start, int end) {
    int pivot = sets[end].length;
    int smallerIdx = start - 1;
    
    for (int i = start; i <= end - 1; i++) {
      if (sets[i].length < pivot) {
        smallerIdx++;
        int[] temp = sets[i];
        sets[i] = sets[smallerIdx];
        sets[smallerIdx] = temp;
      }
    }
    
    int[] temp = sets[smallerIdx + 1];
    sets[smallerIdx + 1] = sets[end];
    sets[end] = temp;
    
    return smallerIdx + 1;
  }
}
