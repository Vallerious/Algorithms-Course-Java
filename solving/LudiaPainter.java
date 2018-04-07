package solving;

import java.util.Scanner;

public class LudiaPainter {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    String input = "-" + scanner.nextLine() + "-";
    String[] canvas = input.split("");
    String[] symbols = {"Y", "M", "C"};
    int filledQuestionsmarks = 0;
    boolean hasTwoOptionsSomewhere = false;
    
    for (int i = 0; i < canvas.length - 1; i++) {
      if (canvas[i].equals("?")) {
        boolean hasOptionsAtAll = false;
        int optionsCount = 0;
        
        for (int j = 0; j < symbols.length; j++) {
          if (!canvas[i - 1].equals(symbols[j]) && !canvas[i + 1].equals(symbols[j])) {
            optionsCount++;
            hasOptionsAtAll = true;
            canvas[i] = symbols[j];
          }
        }
        
        if (hasOptionsAtAll) {
          filledQuestionsmarks++;
        }
        
        if (optionsCount == 2) {
          hasTwoOptionsSomewhere = true;
        }
      }
    }
    boolean isGoodToGo = true;
    for (int i = 1; i < canvas.length - 1; i++) {
      if (canvas[i - 1].equals(canvas[i]) || canvas[i + 1].equals(canvas[i])) {
        isGoodToGo = false;
        break;
      }
    }
    
    if (hasTwoOptionsSomewhere && isGoodToGo) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    
  }

}
