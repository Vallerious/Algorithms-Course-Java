package solving;

import java.util.Scanner;

public class CommonStringSubsequence {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    String str1 = scanner.nextLine();
    String str2 = scanner.nextLine();
    
    String commonSeq = findTheLongestSeq(str1, str2);
    System.out.println(commonSeq);
  }
  
  public static String findTheLongestSeq(String s1, String s2) {
    if (s1.equals(s2)) {
      return s1;
    }
    
    String firstWord;
    String secondWord;
    
    if (s1.length() == s2.length()) {
      firstWord = s1;
      secondWord = s2;
    } else {
      if (s1.length() < s2.length()) {
        firstWord = s1;
        secondWord = s2;
      } else {
        firstWord = s2;
        secondWord = s1;
      }
    }
    
    for (int cutSize = firstWord.length() - 1; cutSize > 0; cutSize--) {
      for (int i = 0; i < firstWord.length() - cutSize; i++) {
        String firstWordCut = firstWord.substring(i, i + cutSize + 1);
        
        for (int j = 0; j < secondWord.length() - cutSize; j++) {
          String secondWordCut = secondWord.substring(j, j + cutSize + 1);
          
          if (firstWordCut.equals(secondWordCut)) {
            return firstWordCut;
          }
        }
      }
    }
    
    return s2;
  }
}
