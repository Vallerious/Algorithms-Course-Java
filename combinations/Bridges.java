package combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridges {

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String[] line = br.readLine().split(" ");
    int len = line.length;
    int[] numbers = new int[len];
    
    for (int i = 0; i < len; i++) {
      numbers[i] = Integer.parseInt(line[i]);
    }
    
    // Algo itself
    int[] bridges = new int[len];
    int lastIdx = 0;
    int bridgesCount = 0;
    
    for (int forwardIdx = 1; forwardIdx < len; forwardIdx++) {
      int forwardNumber = numbers[forwardIdx];
      
      for (int backIdx = lastIdx; backIdx < forwardIdx; backIdx++) {
        int backNumber = numbers[backIdx];
        
        if (forwardNumber == backNumber) {
          bridges[forwardIdx] = 1;
          bridges[backIdx] = 1;
          lastIdx = forwardIdx;
          bridgesCount++;
          break;
        }
      }
    }
    
    if (bridgesCount == 0) {
      System.out.println("No bridges found");
    } else {
      System.out.println(bridgesCount + (bridgesCount == 1 ? " bridge" : " bridges") + " found");      
    }
    
    
    StringBuilder sBuilder = new StringBuilder(len);
    
    for (int i = 0; i < len; i++) {
      if (bridges[i] == 1) {
        sBuilder.append(numbers[i]);
      } else {
        sBuilder.append("X");
      }
      
      sBuilder.append(" ");
    }
    
    System.out.println(sBuilder);
  }

}
