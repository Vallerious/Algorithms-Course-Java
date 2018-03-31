package recursion;

public class RecursiveDrawing {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		draw(5);
//	}
	
	public static void draw(int n) {
		if (n == 0) {
			return;
		}
		
		System.out.println(repeatString("*", n));
		draw(n - 1);
		System.out.println(repeatString("#", n));
	}
	
	public static String repeatString(String s, int i) {
		return new String(new char[i]).replace("\0", s);
	}
}
