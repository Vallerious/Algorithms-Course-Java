package dynamic_programming;

public class RodCutting {
  static int[] prices = {0, 1, 5, 8, 9, 10, 17};
  static int len = 4;
  static int[] bestPrices = new int[prices.length];

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    cutRod(len);
    System.out.println(bestPrices[len]);
  }
  
  public static int cutRod(int n) {
    if (bestPrices[n] > 0) return bestPrices[n];
    if (n == 0) return 0;
    
    int currentBest = bestPrices[n];
    
    for (int i = 1; i <= n; i++) {
      currentBest = Integer.max(currentBest, prices[i] + cutRod(n - i));
      
      if (currentBest > bestPrices[n]) {
        bestPrices[n] = currentBest;
      }
    }
    
    return bestPrices[n];
  }

}
