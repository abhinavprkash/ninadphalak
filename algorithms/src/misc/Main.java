package misc;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import javax.swing.plaf.multi.MultiButtonUI;

public class Main {

	public static void main(String[] args){
/*	String[] input = {"abc", "tac", "bac", "cat"};
	Misc.anagramsTogether(input);
	System.out.println(Arrays.toString(input));
	*/
	/*String input = "abcd1234321lkjs";
	System.out.println(Misc.longestPalindrome(input));*/
	
/*	int[] a = {-2, 3 , 2 , -1};
	System.out.println(Misc.maxContiguousSum(a));
	}*/
		
/*	ArrayList<Integer> numberSet = new ArrayList<Integer>(Arrays.asList(1,2,3));
	ArrayList<ArrayList<Integer>> ans;
	ans= Misc.powerSet(numberSet);
	System.out.println(ans.toString());
	}	*/
/*	String s = "abc";
	//System.out.println(Misc.getPerms(s));
	System.out.println(Misc.getPermBaseAndBuild(s));
	}*/
/*	ArrayList<String> ans = Misc.getBracketPerms(3);
	System.out.println(ans.toString());
	}*/
	
/*    Point p = new Point(1,2);
    Misc.paintFill(p, 3, 3,4);
	}*/
/*    int[] coinTypes = {25,10,5,1}; 
	int ways = Misc.coinChange(100, coinTypes, 0);
	System.out.println("Ways: " + ways);	
	}*/
	//System.out.println(Misc.nQueens(8));
/*	HashMap<Integer,Integer> memo = new HashMap<>();
	System.out.println(Misc.multiplyWithoutMul(8,7,memo));
	}*/
/*	int[] a = { 3,4,-1,0,6,2,3};
	System.out.println(Arrays.toString(Misc.longestIncreasingSequence(a)));
	}*/
/*	int a[] = {2,3,4,5,2,2,2,2,2};
	System.out.println(Misc.getIndex(a,4,0,a.length-1));*/
/*	String[] a = {"at","","","","ball","","","car","","","dad","",""};
	System.out.println(Misc.findStringInSortedArray(a, "ball", 0, a.length));
	}*/
/*	int[][] mat = Misc.generateSortedMartix(6, 5);	
	Misc.printMatrix(mat);
	int x = 24;
	System.out.println("Number to Search is : " + x);
	Point xPosition = Misc.findInSortedMatrix(mat, x, 0, 0, mat.length, mat[0].length);	
	System.out.println("xPosition(x,y) is " + xPosition.x + "," + xPosition.y );
	}	*/
		
	//}
/*	
	int[] weights = {2,3,4};
	int values[] = {4,7,10};
	System.out.println(Misc.knapSack(5, weights, values));*/
	
/*	Point[] points = new Point[6];
	points[0] = new Point(65,100);
	points[1] = new Point(70,150);
	points[2] = new Point(56,90);
	points[3] = new Point(75,190);
	points[4] = new Point(60,95);
	points[5] = new Point(68,110);
	System.out.println("Input :" + Arrays.toString(points));
	ArrayList<Point> result = Misc.circusTower(points);
	System.out.println(result.toString());*/

/*	int[] a = { 1, 2, 4, 6,8,9,10};
	int[] b = { 0,3,10};
	System.out.println(Misc.minDifference(a, b));
	*/
/*    String str = "Mr John Smith       ";
	char[] s =	str.toCharArray();
	System.out.println(Arrays.toString(s));
	System.out.println(Misc.convertStringSpaces(s));*/
		
/*	int[] a = {5,10,15,20,25,30};
	Misc.runningMedian(a);
		
	System.out.println(Integer.MAX_VALUE);*/
	Solution obj = new Solution();
/*	ListNode head = new ListNode(1);
	ListNode second = new ListNode(2);
	head.next = second;*/
	// [1,3],[2,6],[8,10],[15,18],
	//return [1,6],[8,10],[15,18].
	
	/*Interval point1 = new Interval(1,4);
	Interval point2 = new Interval(0,4);
//	Interval point3 = new Interval(8,10);
	//Interval point4 = new Interval(15,18);
	
	List<Interval> points = new ArrayList<>();
	points.add(point1);
	points.add(point2);
//	points.add(point3);
//	points.add(point4);
*/
	//[3,9,20,null,null,15,7]
	TreeNode root = new TreeNode(3);
	TreeNode left = new TreeNode(9);
	TreeNode right = new TreeNode(20);
	root.left = left;
	root.right = right;
	TreeNode tl = new TreeNode(15);
	TreeNode tr = new TreeNode(7);
	right.left = tl;
	right.right = tr;
	//System.out.println(obj.zigzagLevelOrder(root));
	
	String s = "aab";
	int[][] mat = {{1,5,9},{10,11,13},{12,13,15}};
	int[] a = {-2, -1, 2, 1};
	Misc misc = new Misc();
	System.out.println(misc.maxSizeSubarray(a, 1));
	}
}
