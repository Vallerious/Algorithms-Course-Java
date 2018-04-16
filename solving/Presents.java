package solving;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// http://codeforces.com/problemset/problem/136/A
public class Presents {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    String[] numberStrings = scanner.nextLine().split(" ");
    int[] nums = new int[n];
    
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(numberStrings[i]);
    }
    
    Map<Integer, Integer> presentsGiven = new TreeMap<Integer, Integer>();
    
    for (int i = 0; i < nums.length; i++) {
      presentsGiven.put(nums[i], i + 1);
    }
    
    List<String> res = new ArrayList<>();
    
    for (Map.Entry<Integer, Integer> entry : presentsGiven.entrySet()) {
      res.add(entry.getValue() + "");
    }
    
    System.out.println(String.join(" ", res));
  }
}
