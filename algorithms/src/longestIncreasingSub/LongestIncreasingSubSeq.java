package longestIncreasingSub;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubSeq {

	public static void main(String[] args) {
		int[] a = { 0, 2, -1, 0,  8, 10 };
		int ans1 = longestIncreasingSub(a);
		System.out.println(ans1);
		int ans2 = longestIncreasingSubEfficient(a);
		System.out.println("Efficently computed LIS is " + ans2);
	}

	// O(n^2) time
	public static int longestIncreasingSub(int[] a) {
		if (a.length == 0)
			return 0;
		int result[] = new int[a.length];
		 java.util.Arrays.fill(result,1);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					// Valid condition for subsequence
					result[i] = Math.max(result[j] + 1, result[i]);
				}
			}
		}
		System.out.println("old result is: " +  Arrays.toString(result));
		return maxElement(result);
	}

	private static int maxElement(int[] arr) {
		int maxElement = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxElement) {
				maxElement = arr[i];
			}
		}
		return maxElement;
	}

	// In O(nlogn) time
	//Below Code is NOT working and needs fixing**
	public static int longestIncreasingSubEfficient(int[] a) {
		if (a.length == 0) {
			return 0;

		}
		// result[i] stores largest value of list of length i
		int[] result = new int[a.length];
		int lastIndex = 1;// empty cell after last valid value
		for (int i = 0; i < a.length; i++) {
			// Case1: a[i] smaller than smallest element in result[]
			if (a[i] <= result[0]) {
				//creating new list of length 0 with last value as a[i]
				result[0] = a[i];
			}
			// Case3: a[i] greater than the largest element in result[]
			else if (a[i] > result[lastIndex]) {
				result[lastIndex] = a[i];
				lastIndex++;
			} else {
				// Compare with each previously computed list in result
				// Search through the result array for previously computed lists
				// that has the largest number(which will be the largest number
				// in the list of length i) less than A[i]
				int indexOfLargestList = bSearchLargest(result, 0, lastIndex,
						a[i]);
				result[indexOfLargestList] = a[i]; // Append a[i] to result[i],
													// i.e append a[i] to list
													// of length i, a will be
													// the new largest number
				lastIndex++;
			}
		}

		// search through result from the end to find the largest index that has
		// non zero value, this will be the length of the longest subsequence
		System.out.println("Result is: " + Arrays.toString(result));
		for (int i = result.length-1; i > 0; i--) {
			if (result[i] != 0) {
				return i+1;
			}
		}
		return 1;

	}

	public static int bSearchLargest(int[] arr, int startIndex, int endIndex,
			int key) {
		if (startIndex >= endIndex) {
			return startIndex; // If all elements in arr are greater than key,
								// then return 0 i.e startIndex

		}

		// find largest element less than key in arr
		int middleIndex = (startIndex + endIndex) / 2;

		if (arr[middleIndex] <= key && arr[middleIndex + 1] > key) {
			return middleIndex;// return largest number less than key
		}

		if (arr[middleIndex] > key) {
			// look left
			bSearchLargest(arr, startIndex, middleIndex, key);
		} else {
			bSearchLargest(arr, middleIndex, endIndex, key);
		}

		return startIndex; // If all elements in arr are greater than key, then
							// return 0 i.e startIndex

	}
}
