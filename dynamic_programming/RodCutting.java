package dynamic_programming;

import java.util.Scanner;

public class RodCutting {
  
  static int[] bestPrices;
  static int[] prices;
  static int[] bestCombo;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] strings = scanner.nextLine().split(" ");
    prices = new int[strings.length];
    bestPrices = new int[strings.length];
    bestCombo = new int[strings.length];
    int len = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < prices.length; i++) {
      prices[i] = Integer.parseInt(strings[i]);
    }
    
    cutRod(len);
    System.out.println(bestPrices[len]);
    reconstruct(len);
  }
  
  public static int cutRod(int n) {
    if (bestPrices[n] > 0) return bestPrices[n];
    if (n == 0) return 0;
    
    int currentBest = bestPrices[n];
    
    for (int i = 1; i <= n; i++) {
      currentBest = Integer.max(currentBest, prices[i] + cutRod(n - i));
      
      if (currentBest > bestPrices[n]) {
        bestPrices[n] = currentBest;
        bestCombo[n] = i;
      }
    }
    
    return bestPrices[n];
  }
  
  private static void reconstruct(int n ) {
    while (n - bestCombo[n] != 0) {
      System.out.print(bestCombo[n] + " ");
      n = n - bestCombo[n];
    }
    
    System.out.println(bestCombo[n]);
  }

}
