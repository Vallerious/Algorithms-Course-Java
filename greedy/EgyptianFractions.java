package greedy;

import java.util.HashSet;

public class EgyptianFractions {

  public static void main(String[] args) {
    HashSet<String> results = new HashSet<>();
    String[] input = "43/48".split("/");
    int numerator = Integer.parseInt(input[0]);
    int denominator = Integer.parseInt(input[1]);
    int tempNumerator = numerator;
    int candidate = 2;
    
    while (tempNumerator > 0) {
      int leftSideNumerator = tempNumerator * candidate;
      int rightSideNumerator = denominator;
      int substractionBetweenFractions = leftSideNumerator - rightSideNumerator;
      
      if (substractionBetweenFractions >= 1) {
        results.add(String.format("%s/%s", 1, candidate));
        tempNumerator = substractionBetweenFractions;
        
        candidate++;
      } else {
        break;
      }
    }
  }

}
