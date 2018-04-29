package exam_prep;

import java.util.Scanner;

public class Medenka {
  static int puttedPipes = 0;
  static int allPipesCount;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String medenka = scanner.nextLine();
    // split the medenka into pieces and placeholders
    String[] separatedMedenka = medenka.split("");
    allPipesCount = countOfOnes(separatedMedenka) - 1;
    
    split(separatedMedenka, 0, 1);
  }
  
  static void split(String[] m, int start, int idx) {
    if (allPipesCount == puttedPipes) {
      displayResult(m);
      return;
    }
    
    if (idx >= m.length - 1) return;
    
    for (int i = start; i < m.length; i++) {
      if (!m[i].equals("0") && !m[i].equals("1") && canPutBreak(m, start, i)) {
        m[i] = "|";
        puttedPipes++;
        split(m, i + 1, i + 2);
        m[i] = " ";
        puttedPipes--;
      }
    }
  }
  
  static void displayResult(String[] m) {
    StringBuilder sBuilder = new StringBuilder();
    
    for (int i = 0; i < m.length; i++) {
      if (!m[i].equals(" ")) {
        sBuilder.append(m[i]);
      }
    }
    
    System.out.println(sBuilder.toString());
  }
  
  static boolean canPutBreak(String[] mStrings, int start, int idx) {
    for (int i = start; i < idx; i++) {
      if (mStrings[i].equals("1")) {
        return true;
      }
    }
    
    return false;
  }
  
  static int countOfOnes(String[] mStrings) {
    int count = 0;
    
    for (int i = 0; i < mStrings.length; i++) {
      if (mStrings[i].equals("1")) {
        count++;
      }
    }
    
    return count;
  }

}
