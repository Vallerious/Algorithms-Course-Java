package searching;

import java.util.Scanner;
import javax.management.Descriptor;

public class Needles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String n = scanner.nextLine();
		String[] destinationStr = scanner.nextLine().split(" ");
		String[] sourceStr = scanner.nextLine().split(" ");
		
		int[] destination = new int[destinationStr.length];
		int[] source = new int[sourceStr.length];
		
		for (int i = 0; i < destinationStr.length; i++) {
			destination[i] = Integer.parseInt(destinationStr[i]);
		}
		
		for (int i = 0; i < sourceStr.length; i++) {
			source[i] = Integer.parseInt(sourceStr[i]);
		}
		
		for (int i = 0; i < source.length; i++) {
			boolean isFound = false;
			for (int j = 0; j < destination.length; j++) {
				if (destination[j] >= source[i]) {
					if (j == 0) {
						System.out.print(0 + " ");
						isFound = true;
						break;
					} 
						else {
					
						for (int j2 = j - 1; j2 >= 0; j2--) {
							if (destination[j2] > 0) {
								System.out.print((j2 + 1) + " ");
								isFound = true;
								break;
							}
						}						
					}
				} else if (j == destination.length - 1 && source[i] >= destination[j]) {
					System.out.print((destination.length) + " ");
					isFound = true;
					break;
				}
				
				if (isFound) {
					break;
				}
			}
		}
	}

}
