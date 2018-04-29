package combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequencesOfLimitedSum {
  static StringBuilder output = new StringBuilder(100);
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    List<Integer> numbers = new ArrayList<>();
    
    generateVariations(numbers, 0, n);
    
    System.out.println(output);
  }

  private static void generateVariations(List<Integer> numbers, int sum, int max) {
    for (int i = 1; i <= max; i++) {
      if (sum + i <= max) {
        numbers.add(i);
        output.append(concatListOfInt(numbers) + "\n");
        generateVariations(numbers, sum + i, max);
        numbers.remove(numbers.size() - 1);
      } else {
        break;
      }
    }
  }
  
  private static String concatListOfInt(List<Integer> list) {
    StringBuilder sBuilder = new StringBuilder(list.size());
    
    for (int i = 0; i < list.size(); i++) {
      sBuilder.append(list.get(i) + " ");
    }
    
    return sBuilder.toString();
  }

}
