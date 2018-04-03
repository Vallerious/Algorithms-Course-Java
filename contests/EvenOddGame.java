package contests;

import java.util.Scanner;

public class EvenOddGame {

  public static void maina(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    String p1 = "Mahmoud";
    String p2 = "Ehab";

    int n = scanner.nextInt();
    
    
    boolean isMahmootTurn = true;
    boolean isEven = n % 2 == 0;
    if (isEven && isMahmootTurn) {
      // Even
      System.out.println(p1);
      return;
    }
    
    isMahmootTurn = false;
    
    if (!isEven && !isMahmootTurn) {
      System.out.println(p2);
    }
  }

}
