package combinations;

import java.util.HashSet;

public class PermutationsWithRepetition {
  static int[] elements = {1, 2, 2};

  public static void generate(int index) {
    if (index >= elements.length) {
      MyArrayUtils.printArray(elements);
    } else {
      HashSet<Integer> mySet = new HashSet<>();
      
      for (int i = index; i < elements.length; i++) {
        if (!mySet.contains(elements[i])) {
          MyArrayUtils.swapThemElements(elements, index, i);
          generate(index + 1);
          MyArrayUtils.swapThemElements(elements, index, i);
          mySet.add(elements[i]);
        }
      }
    }
  }
}
