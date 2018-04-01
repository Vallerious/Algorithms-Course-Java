package combinations;

public class PermutationsNoRep {
  static int[] elements = {1, 2, 3};
  static boolean[] used = new boolean[elements.length];
  static int[] combinations = new int[elements.length];

//  public static void main(String[] args) {
//    // TODO Auto-generated method stub
//    generate(0);
//  }
  
  public static void generate(int index) {
    if (index > elements.length - 1) {
      MyArrayUtils.printArray(combinations);
      return;
    }
    
    for (int i = 0; i < used.length; i++) {
      if (!used[i]) {
        used[i] = true;
        combinations[index] = elements[i];
        generate(index + 1);
        used[i] = false;
      }
    }
  }

}
