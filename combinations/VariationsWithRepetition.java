package combinations;

public class VariationsWithRepetition {
  static int[] elements = {1, 2, 3};
  static boolean[] used = new boolean[elements.length];
  static int n = 2;
  static int[] variations = new int[n];
  
  public static void generate(int index) {
    if (index >= variations.length) {
      MyArrayUtils.printArray(variations);
    } else {
      for (int i = 0; i < elements.length; i++) {
        variations[index] = elements[i];
        generate(index + 1);
      }
    }
  }
}
