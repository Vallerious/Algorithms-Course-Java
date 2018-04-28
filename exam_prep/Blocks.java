package exam_prep;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Blocks {

  public static void main(String[] args) {
    byte n = takeInput();
    Set<String> results = new TreeSet<>();
    
    for (int firstLetterIdx = 0; firstLetterIdx < n; firstLetterIdx++) {
      for (int secondLetterIdx = firstLetterIdx + 1; secondLetterIdx < n; secondLetterIdx++) {
        for (int thirdLetterIdx = firstLetterIdx + 1; thirdLetterIdx < n; thirdLetterIdx++) {
          if (thirdLetterIdx != secondLetterIdx) {
            for (int fourthLetterIdx = firstLetterIdx + 1; fourthLetterIdx < n; fourthLetterIdx++) {
              if (thirdLetterIdx != fourthLetterIdx && fourthLetterIdx != secondLetterIdx) {
                results.add(((char) (65 + firstLetterIdx)) + "" + ((char) (65 + secondLetterIdx)) + "" + ((char) (65 + thirdLetterIdx)) + "" + ((char) (65 + fourthLetterIdx)));
              }
            }
          }
        }
      }
    }
    
    System.out.println("Number of blocks: " + results.size());
    
    for (String res : results) {
      System.out.println(res);
    }
  }
  
  public static byte takeInput() {
    Scanner scanner = new Scanner(System.in);
    
    return Byte.parseByte(scanner.nextLine());
  }

}
