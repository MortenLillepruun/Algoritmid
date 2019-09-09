package ee.ttu.algoritmid.crypto;

public class Main {

	public static void main(String[] args) {
		AL08A x = new AL08A(23, 5);
		System.out.println(x.crack(8, 18));
		System.out.println(x.crackHarder(8));

	}

}
