package greedy;

public class SumCoins {
  private static int[] coins = {3, 7};
  public static int coinsTaken = 0;
  static int[][] coinsInfo = new int[coins.length][2];
  
//  public static void main(String[] args) {
//    SumCoins.printCoins(SumCoins.getCoins(11));
//  }
  
  public static int[][] getCoins(int sum) {
    int idx = 0;
    int originalSum = sum;
    for (int i = coins.length - 1; i >= 0; i--) {
      int currentCoinValue = coins[i];
      int currentCoinCount = sum / currentCoinValue;
      
      if (currentCoinCount < 1) continue;
      
      coinsTaken += currentCoinCount;
      
      coinsInfo[idx] = new int[2];
      coinsInfo[idx][0] = currentCoinValue;
      coinsInfo[idx][1] = currentCoinCount;
      idx++;
      
      sum = sum % currentCoinValue; 
    }
    
    int checkSum = 0;
    
    for (int i = 0; i < coinsInfo.length; i++) {
      checkSum += coinsInfo[i][1] * coinsInfo[i][0];
    }
    
    if (checkSum < originalSum) {
      return null;
    }
    
    return coinsInfo;
  }
  
  public static void printCoins(int[][] coinsInfo) {
    if (coinsInfo == null) {
      System.out.println("Error");
      return;
    }
    System.out.println("Number of coins to take: " + coinsTaken);
    for (int i = 0; i < coinsInfo.length; i++) {
      int[] currentCoinData = coinsInfo[i];
      if (currentCoinData[0] != 0) {
        System.out.println(currentCoinData[1] + " coin(s) with value " + currentCoinData[0]);        
      }
    }
  }
}
