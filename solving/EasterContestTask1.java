package solving;

import java.util.Scanner;

public class EasterContestTask1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] sentence = scanner.nextLine().split("");
    int ac = 0;
    int bc = 0;
    int cc = 0;
    boolean isValidSentence = true;
    boolean bIsAfterA = false;
    boolean cIsAfterB = false;
    
    for (int i = 0; i < sentence.length; i++) {
      if ((sentence[i].equals("b") || sentence[i].equals("c")) && i == 0) {
        isValidSentence = false;
        break;
      }
      
      if (!bIsAfterA && sentence[i].equals("b") && !sentence[i - 1].equals("a")) {
        isValidSentence = false;
        break;
      }
      
      if (!bIsAfterA && sentence[i].equals("b") && sentence[i - 1].equals("a")) {
        bIsAfterA = true;
      }
      
      if (!bIsAfterA && sentence[i].equals("c") && !sentence[i - 1].equals("b")) {
        isValidSentence = false;
        break;
      }
      
      if (!bIsAfterA && sentence[i].equals("c") && sentence[i - 1].equals("b")) {
        cIsAfterB = true;
      }
      
      if (sentence[i].equals("a")) ac++;
      else if (sentence[i].equals("b")) bc++;
      else cc++;
    }
    
    if ((cc == ac || cc == bc) && isValidSentence) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

}
