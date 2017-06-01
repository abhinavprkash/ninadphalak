package powerSet;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		ArrayList<Integer> inputSet = new ArrayList<Integer>(Arrays.asList(1,2,3));
		ArrayList<ArrayList<Integer>> resultSets = PowerSet.powerSet(inputSet);
		System.out.println("Power Set is: \n");
		for(ArrayList<Integer> subset : resultSets){
			System.out.println(subset.toString());
		}
		
	}
}
