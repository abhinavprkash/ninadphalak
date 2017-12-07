package mergeSort2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		int[] a = { 5, 6,2,3,9,3};
		int[]b = MergeSort.sort(a);
		System.out.println(Arrays.toString(b));
	}
}
