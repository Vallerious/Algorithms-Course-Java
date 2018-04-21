package solving;

import java.util.Scanner;

public class UltraFastMath {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int changesCount = 1;
    String firstLine = scanner.nextLine();
    char currentSymbol = firstLine.charAt(0);

    for (int i = 1; i < n; i++) {
      String currentLine = scanner.nextLine();
      if (currentLine.charAt(0) != currentSymbol) {
        changesCount++;
        currentSymbol = currentLine.charAt(0);
      }
    }
    
    System.out.println(changesCount);
  }

}
