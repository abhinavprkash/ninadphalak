package quicksort2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		int[] a = { 4 , 5, 8, 1 , 2 , 3,6,7};
	//	Quicksort2.sort(a,0,a.length);
		int i = Quicksort2.quickSelect(a, 2, 0, a.length);
		System.out.println(i + " th order statictic is a[i]: " + a[i]);
		//	System.out.println(Arrays.toString(a));
	//	int index = Quicksort2.partition(a, 0, a.length);
	//	System.out.println("partitionIndex: " + index);
	}
}
