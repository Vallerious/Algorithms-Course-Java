package exam_prep;

import java.util.Arrays;
import java.util.Scanner;

public class CableMerchant {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] cables = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int cPrice = sc.nextInt();
    int connectPrice = cPrice * 2;

    for (int i = 1; i < cables.length; i++) {
      int splits = (i + 1) / 2;

      int start = 0;
      int end = i - 1;
      while (splits > 0) {
        cables[i] = Math.max(cables[i], cables[start++] + cables[end--] - connectPrice);
        splits--;
      }
    }

    System.out.println(Arrays.toString(cables).replaceAll("[\\[\\],]", ""));
  }

}
