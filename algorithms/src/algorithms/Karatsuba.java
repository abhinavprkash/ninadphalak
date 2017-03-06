package algorithms;

import java.math.BigInteger;


public class Karatsuba {

	public static BigInteger karatsubaMultiply(BigInteger n, BigInteger m) {
		if (isSingle(n) && isSingle(m)) {
			return n.multiply(m);
		}
		int numAndSumOfN[] = getNumAndSumOfDigits(n);
		int numAndSumOfM[] = getNumAndSumOfDigits(m);

		// Returns an array of two BigIntegers containing (this / val) followed
		// by (this % val).
/*		BigInteger[] splitN = n.divideAndRemainder(BigInteger.valueOf(10 ^ (numAndSumOfN[0] / 2)));
		BigInteger[] splitM = m.divideAndRemainder(BigInteger.valueOf(10 ^ (numAndSumOfM[0] / 2)));
		*/

		BigInteger firstHalfN = n.divide(BigInteger.valueOf((long) Math.pow(10.0,(numAndSumOfN[0] / 2))));
		BigInteger secondHalfN  = n.mod(BigInteger.valueOf((long) Math.pow(10.0,(numAndSumOfN[0] / 2))));
		
	
		BigInteger firstHalfM = m.divide(BigInteger.valueOf((long) Math.pow(10.0,(numAndSumOfM[0] / 2))));
		BigInteger secondHalfM = m.mod(BigInteger.valueOf((long) Math.pow(10.0,(numAndSumOfM[0] / 2))));

		BigInteger a = karatsubaMultiply(firstHalfN,firstHalfM);
		BigInteger d = karatsubaMultiply(secondHalfN, secondHalfM);
		// Note that numAndSumOfN[1] has the sum of digits at 1st index,
		// similarly for M
		// Below is same as finding e(i.e result) = [(Sum of firstHalfN + secondHalfN) * (Sum of firstHalfM + secondHalfM)]-a-d
		BigInteger e = karatsubaMultiply((firstHalfN.add(secondHalfN)),(firstHalfM.add(secondHalfM))).subtract(a).subtract(d);


		BigInteger aResult=  a.multiply(BigInteger.valueOf((long) Math.pow(10, numAndSumOfN[0])));
		BigInteger eResult=  e.multiply(BigInteger.valueOf((long) Math.pow(10,numAndSumOfN[0]/2)));
		//xy  = a*10^n + e * r^n/2 + d    
		return aResult.add(eResult).add(d);

		 
	}

	public static boolean isSingle(BigInteger n) {
		if (n.intValue() <= 9 && n.intValue() >= 0)
			return true;
		return false;
	}

	public static int[] getNumAndSumOfDigits(BigInteger n) {
		int numOfDigits = 0;
		int sumOfDigits = 0;

		// Convert BigInteger to String and then count the digits and also sum
		// of digits, faster than using mod 10
		String digits = n.toString();
		for (int i = 0; i < digits.length(); i++) {
			sumOfDigits += Character.getNumericValue(digits.charAt(i));
			numOfDigits++;
		}
		int[] numAndSum = { numOfDigits, sumOfDigits };
		return numAndSum;

	}

}
