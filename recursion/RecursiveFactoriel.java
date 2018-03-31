package recursion;

public class RecursiveFactoriel {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println(factoriel(10));
//	}
	
	public static int factoriel(int n) {
		if (n == 1) {
			return 1;
		}
		
		return n * factoriel(n - 1);
	}

}
