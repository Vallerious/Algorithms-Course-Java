package combinations;

public class VariationsNoRepetition {
  static int[] elements = {1, 2, 3};
  static boolean[] used = new boolean[elements.length];
  static int n = 3;
  static int[] variations = new int[n];
  
  public static void generate(int index) {
    if (index >= n) {
      MyArrayUtils.printArray(variations);
    } else {
      for (int i = 0; i < elements.length; i++) {
        if (!used[i]) {
          variations[index] = elements[i];
          used[i] = true;
          generate(index + 1);
          used[i] = false;
        }
      }
    }
  }
}
