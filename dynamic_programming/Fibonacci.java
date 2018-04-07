package dynamic_programming;

import java.util.Scanner;

public class Fibonacci {

  public static void maina(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long[] fiboNumbers = new long[1000];
    fiboNumbers[0] = 1;
    fiboNumbers[1] = 1;
    
    
    for (int i = 2; i < fiboNumbers.length; i++) {
      fiboNumbers[i] = fiboNumbers[i - 1] + fiboNumbers[i - 2];
    }
    
    System.out.println(fiboNumbers[n - 1]);
  }

}
