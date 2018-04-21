package solving;

import java.util.HashSet;
import java.util.Scanner;

public class YoungPhisisist {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" ");
		
		int totalSocks = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		int day = 0;
		
		while (true) {
          if (totalSocks == 0) {
            break;
          }
          
          day++;
          totalSocks--;
          
          if (day % m == 0) {
            totalSocks++;
          }
        }
		
		System.out.println(day);
	}

}
