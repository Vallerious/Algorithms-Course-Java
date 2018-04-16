package solving;

import java.util.Scanner;

// http://codeforces.com/problemset/problem/479/A
public class Expression {
  public static void mains(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = Integer.parseInt(scanner.nextLine());
    int b = Integer.parseInt(scanner.nextLine());
    int c = Integer.parseInt(scanner.nextLine());
    int total = 0;
    scanner = null;
    
    total = Integer.max(total, a + b * c);
    total = Integer.max(total, (a + b) * c);
    total = Integer.max(total, a + (b * c));
    total = Integer.max(total, a * b * c);
    total = Integer.max(total, a + b + c);
    total = Integer.max(total, (a * b) + c);
    total = Integer.max(total, a * b + c);
    total = Integer.max(total, a * (b + c));
     
    System.out.println(total);
  }

}
