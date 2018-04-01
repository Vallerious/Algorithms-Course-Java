package combinations;

public class PermutationsNoRepSwap {
  static int[] elements = {1, 2, 3};

  public static void generate(int index) {
    if (index >= elements.length) {
      MyArrayUtils.printArray(elements);
    } else {
      
      generate(index + 1);
      for (int i = index + 1; i < elements.length; i++) {
        MyArrayUtils.swapThemElements(elements, index, i);
        generate(index + 1);
        MyArrayUtils.swapThemElements(elements, index, i);
      }
    }
  }
}
