package recursion;

import java.util.HashSet;

public class EightQueens {
	static int size = 8;
	static int solutionsCount = 0;
	static int[][] chessboard = new int[size][size];
	static HashSet attackedRows = new HashSet();
	static HashSet attackedCols = new HashSet();
	static HashSet attackedLeftDiagonals = new HashSet();
	static HashSet attackedRightDiagonals = new HashSet();
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		putQueens(0);
//		System.out.println(solutionsCount);
//		
//	}
	
	public static void putQueens(int row) {
		if (row == size) {
			solutionsCount++;
			return;
		}
		
		for (int i = 0; i < size; i++) {
			if (canPlaceQueen(row, i)) {
				markAttackedPositions(row, i);
				putQueens(row + 1);
				unmarkAttackedPositions(row, i);
			}
		}
	}
	
	public static boolean canPlaceQueen(int row, int col) {
		boolean positionOccupied = attackedRows.contains(row) || attackedCols.contains(col) || attackedLeftDiagonals.contains(col - row) || attackedRightDiagonals.contains(row + col);
		
		return !positionOccupied;
	}
	
	public static void markAttackedPositions(int row, int col) {
		attackedRows.add(row);
		attackedCols.add(col);
		attackedLeftDiagonals.add(col - row);
		attackedRightDiagonals.add(row + col);
		chessboard[row][col] = 1;
	}
	
	public static void unmarkAttackedPositions(int row, int col) {
		attackedRows.remove(row);
		attackedCols.remove(col);
		attackedLeftDiagonals.remove(col - row);
		attackedRightDiagonals.remove(row + col);
		chessboard[row][col] = 0;
	}

}
