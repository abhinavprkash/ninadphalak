package coinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class coinChangeMap {
	// For an excellent explanation see section 1.7.5 in
	// http://composingprograms.com/pages/17-recursive-functions.html
	public static void main(String args[]) {
		ArrayList<Integer> coinTypes = new ArrayList<Integer>(Arrays.asList(4,
				3, 2, 1));
		int n = 6;
		HashMap<Tuple, Integer> memoMap = new HashMap<Tuple, Integer>();

		int ans = coinChangeMap1(n, coinTypes, 0, memoMap);
		memoMap.toString();
		System.out.println(ans);

	}

	public static int coinChangeMap1(int n, ArrayList<Integer> coinTypes,
			int indexFrom, HashMap<Tuple, Integer> memoMap) {
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
		Tuple tup = new Tuple(n, indexFrom);
		if (memoMap.containsKey(tup)) {
			return memoMap.get(tup);
		}
		/*
		 * System.out.println("n is: " + n + " m is: " + (coinTypes.size() -
		 * indexFrom) + ", memo[n][m] is: " + memoNM[n][indexFrom]);
		 */
		int leftAns = coinChangeMap1(n - coinTypes.get(indexFrom), coinTypes,
				indexFrom, memoMap);
		// memoMap.put(new Tuple(n,indexFrom), leftAns);

		int rightAns = coinChangeMap1(n, coinTypes, ++indexFrom, memoMap);
		memoMap.put(new Tuple(n, indexFrom), leftAns + rightAns);

		return memoMap.get(new Tuple(n, indexFrom));
	}
}
