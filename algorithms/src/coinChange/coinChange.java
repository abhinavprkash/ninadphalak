package coinChange;

import java.util.ArrayList;
import java.util.Arrays;

public class coinChange {
	// For an excellent explanation see section 1.7.5 in
	// http://composingprograms.com/pages/17-recursive-functions.html
	public static void main(String args[]) {
		ArrayList<Integer> coinTypes = new ArrayList<Integer>(Arrays.asList(4,3,2,1));
		int n = 9;
		int[][] memoNM = new int[n + 1][coinTypes.size() + 1];
		// Initialize memoNM

		for (int i = 0; i < memoNM.length; i++) {
			for (int j = 0; j < memoNM[0].length; j++) {
				memoNM[i][j] = 0;
			}
		}

		int ans = coinChange.coinChange1(n, coinTypes, 0, memoNM);
		System.out.println(ans);
		for (int i = 0; i < memoNM.length; i++) {
			System.out.print("i=" + i + " :");
			for (int j = 0; j < memoNM[0].length; j++) {
				System.out.print(memoNM[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static int coinChange1(int n, ArrayList<Integer> coinTypes,
			int indexFrom, int[][] memoNM) {
		// System.out.println("Coin Types: " + coinTypes.toString() + ", n is: "
		// + n + ", m is : " + coinTypes.size());
		if (n < 0) {
			return 0;
		}
		if (indexFrom >= coinTypes.size()) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}
		if (memoNM[n][indexFrom] > 0) {
			return memoNM[n][indexFrom];
		}
		/*
		 * System.out.println("n is: " + n + " m is: " + (coinTypes.size() -
		 * indexFrom) + ", memo[n][m] is: " + memoNM[n][indexFrom]);
		 */
		memoNM[n][indexFrom] = coinChange1(n - coinTypes.get(indexFrom),coinTypes, indexFrom, memoNM);
		
		memoNM[n][indexFrom] += coinChange1(n, coinTypes, ++indexFrom, memoNM);
		return memoNM[n][indexFrom];
	}
}
