package contests;

import java.util.Arrays;
import java.util.Scanner;

public class MahmoutEhabMessages {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    String[] firstLineParams = scanner.nextLine().split(" ");
    int allWordsCount = Integer.parseInt(firstLineParams[0]);
    int groupsCount = Integer.parseInt(firstLineParams[1]);
    int mahmoutMessageWordsCount = Integer.parseInt(firstLineParams[2]);
    
    String[] allWords = scanner.nextLine().split(" ");
    int[] allWordsScores = new int[allWords.length];
    String[] allWordsScoresString = scanner.nextLine().split(" ");
    for (int i = 0; i < allWordsScores.length; i++) {
      allWordsScores[i] = Integer.parseInt(allWordsScoresString[i]);
    }
    
    int[][] groups = new int[groupsCount][];
    
    for (int i = 0; i < groupsCount; i++) {
      String[] groupParams = scanner.nextLine().split(" ");
      groups[i] = new int[Integer.parseInt(groupParams[0])];
      for (int j = 1; j < groupParams.length; j++) {
        groups[i][j - 1] = Integer.parseInt(groupParams[j]);
      }
    }
    
    String[] mahmudMessage = scanner.nextLine().split(" ");
    
    
    // Here comes the real solution
    int total = 0;

    for (int i = 0; i < mahmudMessage.length; i++) {
      String currentWord = mahmudMessage[i];
      int wordIndexInAllWords = Arrays.asList(allWords).indexOf(currentWord) + 1;
      
      int minimumValueIdx = -1;
      for (int j = 0; j < groups.length; j++) {
        int[] currentGroup = groups[j];
        int minimumValue = Integer.MAX_VALUE;
        
        if (getArrayIndex(currentGroup, wordIndexInAllWords) > -1) {
          for (int k = 0; k < currentGroup.length; k++) {
            if (allWordsScores[currentGroup[k] - 1] < minimumValue) {
              minimumValue = allWordsScores[currentGroup[k] - 1];
              minimumValueIdx = currentGroup[k] - 1;
            }
          }
          
          break;
        }
      }
      
      if (minimumValueIdx > -1) {
        mahmudMessage[i] = allWords[minimumValueIdx];
        total += allWordsScores[minimumValueIdx];
      }
    }
    
    System.out.println(total);
  }
  
  public static int getArrayIndex(int[] arr,int value) {

    int k=-1;
    for(int i=0;i<arr.length;i++){

        if(arr[i]==value){
            k=i;
            break;
        }
    }
return k;
}

}
