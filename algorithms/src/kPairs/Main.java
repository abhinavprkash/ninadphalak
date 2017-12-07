package kPairs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args){
		int[] a = {-3,-1,0,2};
		int[] b = {-1, 3,5,6};
		System.out.println(getKPairsMinSum(a, b, 5));
	}
	
	public static List<Point> getKPairsMinSum(int[] a, int[] b, int k){
		PriorityQueue<Point> q = new PriorityQueue<>();
		List<Point> result = new ArrayList<>();
		
		for(int i = 0 ; i < a.length ; i++){
			for(int j = 0 ; j < b.length; j++){
			
				q.add(new Point(a[i],b[j]));
			}
		}
		for(int i = 0; i < k ; i++){
			result.add(q.poll());
		}
		return result;
	}
}
