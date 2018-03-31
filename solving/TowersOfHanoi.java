package solving;

import java.util.Stack;

public class TowersOfHanoi {
	static int stepsTaken = 0;
	static Stack<Integer> source = new Stack<Integer>();
	static Stack<Integer> spare = new Stack<Integer>();
	static Stack<Integer> destination = new Stack<Integer>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		source.push(3);
//		source.push(2);
//		source.push(1);
//		printRods();
//		moveDisks(3, source, destination, spare);
//	}
	
	public static void moveDisks(int bottomDisk, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> spare) {
		if (bottomDisk == 1) {
			destination.push(source.pop());
			stepsTaken++;
			System.out.println("Disk moved: " + bottomDisk + "; Steps taken: " + stepsTaken);
			printRods();
		} else {
			moveDisks(bottomDisk - 1, source, spare, destination);
			destination.push(source.pop());
			moveDisks(bottomDisk - 1, spare, destination, source);
		}
	}
	
	public static void printRods() {
		System.out.print("Source rod: " );
		for (Integer integer : source) {
			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.print("Spare rod: " );
		for (Integer integer : spare) {
			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.print("Destination rod: " );
		for (Integer integer : destination) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

}
