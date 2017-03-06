package algorithms;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		BigInteger n = new BigInteger("1234");
        BigInteger m = new BigInteger("4321");
		System.out.println(Karatsuba.karatsubaMultiply(n, m));

	}

}
