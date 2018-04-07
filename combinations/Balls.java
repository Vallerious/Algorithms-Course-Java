package combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Balls {
  static int[] elements;
  static boolean[] used;
  static int k;
  static int n;
  static int p;
  static int[] variations;
  static HashSet<String> res = new HashSet<>();
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    p = scanner.nextInt();
    n = scanner.nextInt();
    k = scanner.nextInt();
    used = new boolean[k];
    variations = new int[p];
    elements = new int[k];
    
    for (int i = 1; i <= k; i++) {
      elements[i - 1] = i;
    }
    generate(0);
    
    for (String string : res) {
      System.out.println(string);
    }
  }
  
  public static void generate(int index) {
    if (index >= variations.length) {
      int sum = 0;
      
      for (int i = 0; i < variations.length; i++) {
        sum += variations[i];
      }
      
      if (sum == n) {
        List<String> temp = new ArrayList<>();
        
        for (int i = 0; i < variations.length; i++) {
          temp.add(variations[i] + "");
        }
        
        res.add(String.join(", ", temp));
      }
    } else {
      for (int i = 0; i < elements.length; i++) {
        variations[index] = elements[i];
        generate(index + 1);
      }
    }
  }
}
