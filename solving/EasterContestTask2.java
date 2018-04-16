package solving;

import java.util.Scanner;

public class EasterContestTask2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] flparams = scanner.nextLine().split(" ");
    int sizeOfArrays = Integer.parseInt(flparams[0]);
    int numOpForA = Integer.parseInt(flparams[1]);
    int numOpForB = Integer.parseInt(flparams[2]);
    
    int[] A = new int[sizeOfArrays];
    int[] B = new int[sizeOfArrays];
    
    String[] aStrings = scanner.nextLine().split(" ");
    
    for (int i = 0; i < aStrings.length; i++) {
      A[i] = Integer.parseInt(aStrings[i]);
    }
    
    String[] bStrings = scanner.nextLine().split(" ");
    
    for (int i = 0; i < bStrings.length; i++) {
      B[i] = Integer.parseInt(bStrings[i]);
    }
    
    for (int i = 0; i < sizeOfArrays; i++) {
      if (A[i] - B[i] == 0) continue;
      
      if (A[i] < B[i] && numOpForA > 0) {
        int diff = Math.abs(A[i] - B[i]);
        
        if (diff <= numOpForA) {
          A[i] += diff;
          numOpForA -= diff;
        } else {
          A[i] += numOpForA;
          numOpForA = 0;
        }
      } else if (A[i] > B[i] && numOpForB > 0) {
        int diff = Math.abs(B[i] - A[i]);
        
        if (diff <= numOpForB) {
          B[i] += diff;
          numOpForB -= diff;
        } else {
          B[i] += numOpForB;
          numOpForB = 0;
        }
      }
      
      if (B[i] > A[i] && numOpForA == 0) {
        int diff = Math.abs(B[i] - A[i]);
        
        if (diff <= numOpForB) {
          B[i] -= diff;
          numOpForB -= diff;
        } else {
          B[i] -= numOpForB;
          numOpForB = 0;
        }
      } else if (A[i] > B[i] && numOpForB == 0) {
        int diff = Math.abs(B[i] - A[i]);
        
        if (diff <= numOpForA) {
          A[i] -= diff;
          numOpForA -= diff;
        } else {
          A[i] -= numOpForA;
          numOpForA = 0;
        }
      }
    }
    
    while (numOpForA > 0) {
      A[0]++;
      numOpForA--;
    }
    
    while (numOpForB > 0) {
      B[0]++;
      numOpForB--;
    }
    
    int total = 0;
    
    for (int j = 0; j < sizeOfArrays; j++) {
      total += ((A[j] - B[j]) * (A[j] - B[j]));
    }
    
    System.out.println(total);
  }

}
