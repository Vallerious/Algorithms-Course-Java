package combinations;

import java.util.Scanner;

public class Sowing {
  static int[] field;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    String[] line = scanner.nextLine().split(" ");
    int len = line.length;
    field = new int[len];
    
    for (int i = 0; i < len; i++) {
      field[i] = Integer.parseInt(line[i]);
    }
    int[] numbers = new int[n];

    generateCombinationsWithoutRep(numbers, 0, 0, len - 1);
  }

  public static void generateCombinationsWithoutRep(int[] nums, int idx, int start, int choiceCount) {
    if (nums.length <= idx) {
      print(nums);
      return;
    }

    for (int i = start; i <= choiceCount; i++) {
      if (field[i] == 0) continue;
      nums[idx] = i;
      generateCombinationsWithoutRep(nums, idx + 1, i + 2, choiceCount);
    }
  }

  public static void print(int[] arr) {
    StringBuilder builder = new StringBuilder(field.length);
    
    for (int i = 0; i < field.length; i++) {
      builder.append(field[i] + "");
    }
    
    for (int i = 0; i < arr.length; i++) {
      builder.setCharAt(arr[i], '.');
    }
    
    System.out.println(builder.toString());
  }

}
