package powerSet;

import java.util.ArrayList;

public class PowerSet {

	public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> allSets = new ArrayList<ArrayList<Integer>>();
		if (a.isEmpty()) {
			// Empty Set
			allSets.add(new ArrayList<Integer>());
			return allSets;
		}

		int item = a.remove(0);// remove first element
		allSets.addAll(powerSet(a));
		
		ArrayList<ArrayList<Integer>> moreSets = new ArrayList<ArrayList<Integer>>();
		// Append item to all sets in allSets
		for (ArrayList<Integer> subSet : allSets) {
			ArrayList<Integer> newSet = new ArrayList<Integer>();
			newSet.addAll(subSet);
			newSet.add(item);
			moreSets.add(newSet);

		}
		allSets.addAll(moreSets);
/*		System.out.println("Added sets: ");
		for (ArrayList<Integer> subset : allSets) {
			System.out.println(subset.toString());
		}*/
		return allSets;
	}

}
