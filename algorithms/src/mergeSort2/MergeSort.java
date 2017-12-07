package mergeSort2;

import java.util.Arrays;

public class MergeSort {

	public static int[] sort(int[] a) {

		while (a.length > 1) {
			int mid = a.length / 2;
			int[] leftArray = Arrays.copyOfRange(a, 0, mid);
			int[] rightArray = Arrays.copyOfRange(a, mid, a.length);
			System.out.println("leftArray: " + Arrays.toString(leftArray));
			System.out.println("rightArray: " +Arrays.toString(rightArray) );
			int[] leftSorted = sort(leftArray);
			int[] rightSorted = sort(rightArray);
			return merge(leftSorted, rightSorted);
		}
		return a;
	}

	public static int[] merge(int[] leftArray, int[] rightArray) {
		 int[] result = new int[leftArray.length + rightArray.length];
		int indexLeft = 0;
		int indexRight = 0;
		int indexResult = 0;
		while (indexLeft < leftArray.length && indexRight < rightArray.length) {
			if (leftArray[indexLeft] <= rightArray[indexRight]) {
				result[indexResult] = leftArray[indexLeft];
				indexLeft++;
			} else {
				result[indexResult] = rightArray[indexRight];
				indexRight++;
			}
			indexResult++;
		}
		while (indexLeft < leftArray.length) {
			result[indexResult++] = leftArray[indexLeft++];
		}
		while (indexRight < rightArray.length) {
			result[indexResult++] = rightArray[indexRight++];
		}
		return result;
	}
}
