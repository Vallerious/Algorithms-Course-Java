package solving;

import java.util.Scanner;

public class BeautifulYear {

  public static void mains(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int year = scanner.nextInt();
    
    for (int i = year + 1; i <= 100 * 1000; i++) {
      int temp = i;
      int lastDigit = temp % 10;
      temp /= 10;
      int thirdDigit = temp % 10;
      temp /= 10;
      int secondDigit = temp % 10;
      temp /= 10;
      int firstDigit = temp % 10;
      temp /= 10;
      
      if (lastDigit != thirdDigit && lastDigit != secondDigit && lastDigit != firstDigit && secondDigit != thirdDigit && secondDigit != firstDigit &&
          thirdDigit != firstDigit) {
        System.out.println(i);
        return;
      }
    }
  }
}
