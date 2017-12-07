package quicksort2;

import java.util.Arrays;

public class Quicksort2 {

	public static int quickSelect(int[] a, int k, int low, int high) {
		// find the kth order statistic
		if (low < high) {
			int pivotIndex = partition(a, low, high);
			if (k == pivotIndex) {
				return k;
			}
			if (k < pivotIndex) {
				// look left
				return quickSelect(a, k, low, pivotIndex);
			} else {
				// look right
				return quickSelect(a, k, pivotIndex + 1, high);

			}

		}
		return -1;
	}

	public static void sort(int[] a, int low, int high) {

		if (low < high) {
			// int pivotIndex = partitionLast(a,low,high);
			int pivotIndex = partition(a, low, high);
			System.out.println("pivotIndex: " + pivotIndex + " low: " + low
					+ " high: " + high);
			sort(a, low, pivotIndex);
			sort(a, pivotIndex + 1, high);

		}

	}

	public static int partitionLast(int[] a, int low, int high) {
		int pivot = a[high - 1];
		int i = low;
		for (int j = low; j < high - 1; j++) {
			if (a[j] < pivot) {
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
			}
		}
		a[high - 1] = a[i];
		a[i] = pivot;
		return i;

	}

	public static int partition(int[] a, int low, int high) {
		int pivot = a[low];
		// System.out.println("pivot is: " + pivot);
		int i = low + 1;

		for (int j = low + 1; j < high; j++) {
			if (a[j] < pivot) {
				// bring on left of i wall
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				// System.out.println("i: " + i);
			}
		}
		// move pivot to ith position
		a[low] = a[i - 1];
		a[i - 1] = pivot;
		// System.out.println("array: " + Arrays.toString(a));
		return i - 1;

	}
}
