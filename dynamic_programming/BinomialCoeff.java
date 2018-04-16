package dynamic_programming;

import java.util.Scanner;

public class BinomialCoeff {
  public static long[][] cache = new long[1000][1000];

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    System.out.println(binom(n, k));
  }
  
  public static long binom(int n, int k) {
    if (cache[n][k] != 0) {
      return cache[n][k];
    }
    
    if (k >= n || k == 0) {
      return 1;
    }
    
    long res = binom(n - 1, k - 1) + binom(n - 1, k);
    
    cache[n][k] = res;
    
    return res;
  }

}
