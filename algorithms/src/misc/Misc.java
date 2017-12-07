package misc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Map.Entry;
import java.util.Stack;

public class Misc {
		
	public int removeDuplicates(int[] nums) {
	/*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

			Do not allocate extra space for another array, you must do this in place with constant memory.

			For example,
			Given input array nums = [1,1,2],

			Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
			*/
		int end = nums.length;
		int i = 0;
		while(i < end){
			if(nums[i]==nums[i-1]){
				end--;
				int temp = nums[end];
				nums[end] = nums[i];
				nums[i] = temp;
				continue;
			}else{
				i++;
			}
		}
		return end-1;
	}		
	
	
	 public boolean isValid(String s){
		 /* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

		The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/
		 Stack<Character> stk = new Stack<>();
		 for(int i = 0 ; i < s.length() ; i++){
			 char c = s.charAt(i);
			 if(c == '(') stk.push(')');
			 else if(c == '{') stk.push('}');
			 else if(c == '[') stk.push(']');
			 else if(c != stk.pop() || s.isEmpty()){
				 return false;
			 }
		 }
		 return stk.isEmpty();
		 
	 }
		public List<String> letterCombinations(String digits){
			HashMap<Integer, String> hm = new HashMap<>();
			hm.put(2, "abc");
			hm.put(3,"def");
			hm.put(4,"ghi");
			hm.put(5,"jkl");
			hm.put(6,"mno");
			hm.put(7,"pqrs");
			hm.put(8,"tuv");
			hm.put(9,"wxyz");
			
			if(digits.length() == 0)return new ArrayList<String>();
			if(digits.length() == 1){
				int d = Integer.parseInt(String.valueOf(digits.charAt(0)));
				char[] letters = hm.get(d).toCharArray();
				ArrayList<String> oneList = new ArrayList<String>();
				for(char c: letters){
					String s = Character.toString(c);
					oneList.add(s);
					
				}
				return oneList;
			}
			
			List<String> resultList = new ArrayList<>();
			int d = Integer.parseInt(String.valueOf(digits.charAt(0)));
			char[] cArray = hm.get(d).toCharArray();
			for(char c : cArray){
				List<String> partialsList = letterCombinations(digits.substring(1));
				
				for(String p : partialsList){
					String word = c + p;
					resultList.add(word);
					
				}
			}
			return resultList;
		}
	
		public int maxSizeSubarray(int[] a, int k){
			/*Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
			Example 1:
			Given nums = [1, -1, 5, -2, 3], k = 3,
			return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)*/
			if(a.length == 0) return 0;
			HashMap<Integer,Integer> sumIndexMap = new HashMap<>();
			int maxLen = 0;
			int sum = 0;
			sumIndexMap.put(0,-1);
			for(int i = 0; i < a.length ; i++){
				sum = sum + a[i];
				if(!sumIndexMap.containsKey(sum)){
					sumIndexMap.put(sum,i);
				}
				if(sumIndexMap.containsKey(sum-k)){
					maxLen = Math.max(maxLen, i - sumIndexMap.get(sum-k));
				}
			}
			return maxLen;
		}
	
	   public int binSearchNearestZero(int[] a, int low, int high, int target){

		   int mid=low; 
		   while(low <= high){
			   mid = (low+high)/2;
			   if(a[mid]==target) return mid;
		   
			   else if(target < a[mid]){
				  high = mid-1;
			   }
			   else 
			  {
				  low = mid+1;
				   
			  }
		   }	   
		   if(Math.abs(a[low] - target) < Math.abs(a[high] - target)){
			   return low;
		   }
		   else return high;
	   }
	   public List<Integer> topKFrequent(int[] nums, int k) {
	        HashMap<Integer,Integer> freqMap = new HashMap<>();
	        for(int n : nums){
	            if(!freqMap.containsKey(n)){
	                freqMap.put(n,0);
	            }
	            freqMap.put(n,freqMap.get(n)+1);
	        }
	        
	        class FreqComparator implements Comparator<Map.Entry<Integer,Integer>>{
	            @Override
	            public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2){
	            	return o1.getValue().compareTo(o2.getValue());
	            }
	        }
	        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(new FreqComparator());
	        for(Entry<Integer,Integer> e: freqMap.entrySet()){
	        	int freq = e.getValue();
	        	if(minHeap.size()>=k){
	        		 if(minHeap.peek().getValue() < freq){
	        			 minHeap.poll();
	        			 System.out.println("Adding*" + e.getKey());
	        			 minHeap.add(e);
	        		 }
	        	}
	        	else{
	        	System.out.println("Adding" + e.getKey());
	        		minHeap.add(e);
	        	}
	        }
	      
	        List<Integer> result = new ArrayList<>();
	        while(result.size() < k && !minHeap.isEmpty()){
	        	Map.Entry<Integer,Integer> e = minHeap.poll();
	        	
	        	result.add(e.getKey());
	        }
	        return result;
	    }
	public static List<String> getMissingRange(int[] a) {
		// Given a sorted integer array where the range of elements are [0, 99]
		// inclusive,
		// return its missing ranges. For example, given [0, 1, 3, 50, 75],
		// return [“2”, “4->49”, “51->74”, “76->99”]
		List<String> ranges = new ArrayList<String>();
		if (a.length == 0) {
			ranges.add(getRange(-1, 100));
			return ranges;
		}
		if (a[0] > 0) {
			ranges.add(getRange(-1, a[0]));

		}
		for (int i = 1; i < a.length; i++) {
			if (a[i] - a[i - 1] > 1) {
				ranges.add(getRange(a[i - 1], a[i]));
			}
		}
		if (a[a.length - 1] < 99) {
			ranges.add(getRange(a[a.length - 1], 100));
		}
		return ranges;

	}

	private static String getRange(int left, int right) {
		if (right - left == 2) {
			return (Integer.toString(++left));
		}
		return (new String(++left + "->" + --right));
	}

	public static void runningMedian(int[] a) {
		// at any point while reading a we can get the correct median by usig
		// two heaps
		// i.e max heap keeps lower half elements and bmin heap keeps upper half
		// elements
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
				Collections.reverseOrder());
		int median = 0;
		for (int i = 0; i < a.length; i++) {

			if (minHeap.size() <= maxHeap.size()) {
				// add to maxHeap
				minHeap.add(a[i]);

			} else {
				maxHeap.add(a[i]);
			}
			if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				rebalanceAndSwap(minHeap, maxHeap);
			}
			median = getRunningMedian(minHeap, maxHeap);
			System.out.println("Current running median of i: " + i + " is :"
					+ median);
		}

	}

	public static int getRunningMedian(PriorityQueue<Integer> minHeap,
			PriorityQueue<Integer> maxHeap) {
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else if (minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		}
		if (minHeap.size() == maxHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2;
		}
		return 0;
	}

	public static void rebalanceAndSwap(PriorityQueue<Integer> minHeap,
			PriorityQueue<Integer> maxHeap) {
		if (minHeap.peek() < maxHeap.peek()) {
			int minA = minHeap.poll();
			int maxB = maxHeap.poll();
			minHeap.add(maxB);
			maxHeap.add(minA);
		}

	}

	public static char[] convertStringSpaces(char[] s) {
		// first pass find spaces
		int spaces = 0;
		int lastIndex = s.length - 1;

		for (lastIndex = s.length - 1; lastIndex > 0; lastIndex--) {
			if (s[lastIndex] != ' ') {
				break;
			}
		}

		for (int i = lastIndex; i > 0; i--) {
			// count actual spaces
			if (s[i] == ' ') {
				spaces++;
			}
		}
		System.out.println("spacin string are : " + spaces + " lastIndex is: "
				+ lastIndex);
		int newLastIndex = lastIndex + spaces * 2;

		for (int i = newLastIndex; i >= 0 && lastIndex >= 0; i--) {
			System.out.println("lastIndex: " + lastIndex + " ,newLastIndex: "
					+ newLastIndex);
			System.out.println("s is: " + Arrays.toString(s));
			if (s[lastIndex] == ' ') {
				s[newLastIndex--] = '0';
				s[newLastIndex--] = '2';
				s[newLastIndex--] = '%';
				lastIndex--;
			} else {
				s[newLastIndex--] = s[lastIndex--];
			}

		}
		return s;
	}

	public static int minDifference(int[] a, int[] b) {
		Integer indexA = 0;
		Integer indexB = 0;
		int minDiff = Integer.MAX_VALUE;
		while (indexA < a.length && indexB < b.length) {
			System.out.println("indexA : " + indexA);
			System.out.println(("indexB: " + indexB));
			int diff = Math.abs(a[indexA] - b[indexB]);
			if (diff < minDiff) {
				minDiff = diff;
			}
			if (a[indexA] < b[indexB]) {
				// a[indexA] is bigger, so increase indexB
				indexA++;
			} else {
				indexB++;
			}
		}
		System.out.println("indexA : " + indexA);
		System.out.println(("indexB: " + indexB));
		return minDiff;
	}

	public static ArrayList<Point<Integer, Integer>> circusTower(
			Point<Integer, Integer>[] inputPairs) {
		Arrays.sort(inputPairs);
		System.out.println("Sorted wrt x: " + Arrays.toString(inputPairs));
		int[] resultPairs = new int[inputPairs.length];
		ArrayList<Point<Integer, Integer>> resultList = new ArrayList<Point<Integer, Integer>>();
		// now find longest increasing subsequence wrt y coordinate
		boolean isInsideLoop = false;
		for (int i = 1; i < inputPairs.length; i++) {
			for (int j = 0; j < i; j++) {
				isInsideLoop = false;
				if (inputPairs[j].y.compareTo(inputPairs[i].y) < 1) {
					// include i th only if it is greater than j th y
					if (resultPairs[i] > 1 + resultPairs[j]) {
						resultPairs[i] = resultPairs[i];
						resultList.add(inputPairs[i]);

					} else {
						resultPairs[i] = 1 + resultPairs[j];

					}
					isInsideLoop = true;
				}

			}
			if (isInsideLoop) {
				if (i == 1) {
					resultList.add(inputPairs[0]);
				}
				resultList.add(inputPairs[i]);
				isInsideLoop = false;
			}
		}

		return resultList;
	}

	public static int knapSack(int capacity, int[] weight, int[] value) {

		// dp table would have columns = capacity, and rows = number of items
		int[][] dp = new int[weight.length][capacity + 1];

		// intitalize table for 0th column(base case)
		for (int i = 0; i < weight.length; i++) {
			dp[i][0] = 0;
		}
		// now iterate through the dp table to fill in values bottom up
		for (int i = 0; i < weight.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				System.out.println("i: " + i + " j:" + j + " dp[i][j]:"
						+ dp[i][j] + " weight[i]:" + weight[i]);

				if (weight[i] > j) {
					// item weight is greater than total available weight, so
					// you cannot take current item
					if (i > 0) {
						dp[i][j] = dp[i - 1][j];
					}

				} else {

					/*
					 * 1. Least number of denominations(coins) to get change
					 * 'n': Min(T[i-1][j], 1 + T[i][j-C[i]) 2. Rod cutting
					 * problem: Max(T[i-i][j], C[i]+T[i][j-C[i]]) 3. Rope
					 * cutting problem: Max(T[i][j-1],C[i]* T[i][j-C[i]])
					 */

					// Consider the current item and take max of 'without item'
					// and 'with item'
					if (i > 0) {
						dp[i][j] = Math.max(dp[i - 1][j], value[i]
								+ dp[i][j - weight[i]]);

					} else {
						dp[i][j] = value[i] + dp[i][j - weight[i]];
					}

				}

			}
		}

		return dp[weight.length - 1][capacity];

	}

	/*
	 * public static Point[] longestIncreasingXY(Point[] points){ //sort by x
	 * then by y, then find longest increasing subsequence to get the tower
	 * height //if (x,y) = weight, height, you can put point p2 on top of p1
	 * only if p1 has x&y lesss that p2's x&y
	 * 
	 * 
	 * }
	 */
	public static Point findInSortedMatrix(int[][] mat, int x, int lowi,
			int lowj, int highi, int highj) {
		// buggy method
		// Get matrix mid, then search if x is present in each quadrant,
		// remember quadrant is sorted
		if (lowi > highi || lowj > highj)
			return new Point(-1, -1);
		int midi = (lowi + highi) / 2;
		int midj = (lowj + highj) / 2;

		if (mat[midi][midj] == x) {
			return new Point(midi, midj);
		}
		// First quadrant (lowi, lowj) to (midi,midj)
		if (mat[lowi][lowj] < x && x <= mat[midi][midj]) {
			findInSortedMatrix(mat, x, lowi, lowj, midi, midj);
		}
		// Second quadrant is (lowi,midj+1) to (midi,highj-1)
		if (mat[lowi][midj + 1] < x && x <= mat[midi][highj - 1]) {
			findInSortedMatrix(mat, x, lowi, midj + 1, midi, highj - 1);
		}
		// Third Quadrant is (midi+1,lowj) to (highi-1,midj)
		if (mat[midi + 1][lowj] < x && x <= mat[highi - 1][midj]) {
			findInSortedMatrix(mat, x, midi + 1, lowj, highi - 1, midj);
			// Fourth Quadrant is (midi+1,midj+1) to (highi-1, highj-1)
			if (mat[midi + 1][midj + 1] < x && x <= mat[highi - 1][highj - 1]) {
				findInSortedMatrix(mat, x, midi + 1, midj + 1, highi - 1,
						highj - 1);
			}
		}
		return new Point(-1, -1);
	}

	public static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] < 10) {
					System.out.print(mat[i][j] + "     ");
				} else
					System.out.print(mat[i][j] + "    ");
			}
			System.out.println();
		}
	}

	public static int[][] generateSortedMartix(int row, int col) {
		int[][] mat = new int[row][col];
		int seed = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				mat[i][j] = seed++;
			}
		}
		return mat;
	}

	public static int findStringInSortedArray(String[] words, String s,
			int low, int high) {
		if (s.isEmpty()) {
			return -1;
		}
		int mid = (low + high) / 2;

		if (words[mid] == "") {
			int left = mid - 1;
			int right = mid + 1;
			while (left > 0 && right < high) {
				// search left and right for non empty word from mid

				if (left > 0 && words[left] != "") {
					mid = left;
					break;
				}
				if (right < high && words[right] != "") {
					mid = right;
					break;
				}
				left--;
				right++;

			}
		}
		if (words[mid].equals(s)) {
			return mid;
		} else
		// Now mid is at a valid word
		if (words[mid].compareTo(s) > 0) {
			return findStringInSortedArray(words, s, low, mid - 1);
		} else {
			return findStringInSortedArray(words, s, mid + 1, high - 1);
		}

	}

	public static int getIndex(int[] a, int x, int low, int high) {
		if (low > high)
			return -1;

		int mid = (low + high) / 2;
		if (a[mid] == x) {
			return mid;
		}
		System.out.println("Array a is: " + Arrays.toString(a));
		System.out.println("x: " + x + " low: " + low + " high: " + high);
		// a is sorted but rotated
		if (a[low] < a[mid]) {
			// left is sorted
			// check if present in left
			if (x > a[low] && x < a[mid]) {
				// x falls in left
				return getIndex(a, x, 0, mid - 1);
			} else {
				// find in right half
				return getIndex(a, x, mid + 1, high);
			}
		}

		else if (a[mid] < a[high]) {
			// right is sorted
			if (x > a[mid] && x < a[high]) {
				return getIndex(a, x, mid + 1, high);
			} else {
				// find in left
				return getIndex(a, x, 0, mid - 1);
			}

		}
		// if duplicates are present
		else if (a[mid] == a[low]) {// Question: shouldn't there be a
									// if(a[mid]==a[high])??
			// left half has the same elements
			// find in right provided right half has unique element
			if (a[mid] != a[high]) {
				getIndex(a, x, mid + 1, high);
			}
		} else if (a[mid] == a[high]) {
			// right half equal, find in left
			if (a[mid] != a[low]) {
				getIndex(a, x, low, mid - 1);
			}
		}

		// need to search both halves
		int left = getIndex(a, x, low, mid - 1);
		if (left != -1) {
			return left;
		} else {
			return getIndex(a, x, mid + 1, high);
		}

	}

	public static int[] longestIncreasingSequence(int[] arr) {
		int[] result = new int[arr.length];
		Arrays.fill(result, 1);
		int[] indexArrayResult = new int[arr.length];
		Arrays.fill(indexArrayResult, 0);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					// result[i] = Math.max(result[j] + 1, result[i]);
					if (result[j] + 1 > result[i]) {
						result[i] = result[j] + 1;
						indexArrayResult[i] = j;
					} else {
						indexArrayResult[i] = i;
					}
				}
			}
		}
		// ArrayList<Integer> longestSeqList = new ArrayList<Integer>();
		// find l
		System.out.println(Arrays.toString(indexArrayResult));
		return result;
	}

	public static int multiplyWithoutMul(int a, int b,
			HashMap<Integer, Integer> memo) {
		if (memo.get(b) != null) {
			return memo.get(b);
		}
		if (b == 1)
			return a;
		int b2 = b >> 1;
		int b3 = (b - b2);// if b was odd
		int temp;
		if (b2 == b3) {
			temp = multiplyWithoutMul(a, b2, memo);
			int result = temp + temp;
			memo.put(b, result);
			return result;
		} else {
			// b was odd
			temp = multiplyWithoutMul(a, b2, memo)
					+ multiplyWithoutMul(a, b3, memo);
			memo.put(b, temp);
		}
		return memo.get(b);

	}

	public static int nQueens(int boardSize) {
		int[] column = new int[boardSize];
		ArrayList<int[]> result = new ArrayList<int[]>();
		placeQueens(boardSize, 0, column, result);
		return result.size();
	}

	private static ArrayList<int[]> placeQueens(int n, int row, int[] columns,
			ArrayList<int[]> columnsList) {
		if (row >= n) {
			// all queens have been successfully placed in column[] array
			columnsList.add(columns);
			return columnsList;
		}
		for (int i = 0; i < columns.length; i++) {
			if (isValid(row, i, columns)) {
				// place Queen
				columns[row] = i;
				columnsList = placeQueens(n, row + 1, columns, columnsList);
			}
		}
		return columnsList;
	}

	public static boolean isValid(int row, int col, int[] columns) {
		// row,col is the new queen position to check
		// all old queen positions are in column[] before index col
		for (int irow = 0; irow < row; irow++) {
			int icol = columns[irow];
			// irow, icol is the position of earlier placed queen

			if (icol == col)
				return false;// check if on same column
			// now check for diagonal, no need to check for row
			int rowDist = row - irow;
			int colDist = Math.abs(col - icol);
			if (rowDist == colDist)
				return false;// on the same daignoal as earlier queen at
								// irow,icol

		}
		return true;
	}

	// To do below: Memoization
	public static int coinChange(int n, int[] m, int startIndex) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (startIndex == m.length)
			return 0;
		int numWays = coinChange(n - m[startIndex], m, startIndex)
				+ coinChange(n, m, ++startIndex);
		return numWays;
	}

	public static void paintFill(Point<Integer, Integer> p, int n, int m,
			int colorToFill) {
		int[][] colors = new int[n][m];

		// fill colors with colors represented by integers 1,2,3 for red,blue,
		// green
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Random rnd = new Random();
				colors[i][j] = rnd.nextInt(3);
			}
		}

		System.out.println("PointX is :" + p.getX() + " , " + "PointY is "
				+ p.getY() + " colors[x][y] is: "
				+ colors[(int) p.getX()][(int) p.getY()]);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(colors[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("New color is: " + colorToFill);
		int oldColor = colors[(int) p.getX()][(int) p.getY()];
		paintFillUtil(colors, p.getX(), p.getY(), colorToFill, oldColor);
		System.out.println("Output is: \n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(colors[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void paintFillUtil(int colors[][], int r, int c,
			int newColor, int oldColor) {

		int rowLength = colors.length;
		int colLength = colors[0].length;
		if (r < 0 || c < 0 || r >= rowLength || c >= colLength) {
			return;
		}
		if (colors[r][c] != oldColor) {
			// Fill colors[p.x][p.y] with colorToFill

			return;
		}
		colors[r][c] = newColor;

		// search recursively left, right, top, bottom
		// Go left

		paintFillUtil(colors, r, c - 1, newColor, oldColor);
		// go right
		paintFillUtil(colors, r, c + 1, newColor, oldColor);
		// go top
		paintFillUtil(colors, r - 1, c, newColor, oldColor);
		// go bottom
		paintFillUtil(colors, r + 1, c, newColor, oldColor);

	}

	public static ArrayList<String> getBracketPerms(int n) {
		ArrayList<String> result = new ArrayList<String>();
		getBracketPerms(new String(), n, n, result);
		return result;
	}

	private static void getBracketPerms(String s, int i, int j,
			ArrayList<String> result) {
		// i is number of opening brackets remaining, j is number of closing
		// brackets remaining

		if (i == 0 && j == 0) {
			result.add(s);
			System.out.println(s);
			return;
		}

		if (i >= 1) {
			getBracketPerms(s + "(", i - 1, j, result);
		}
		if (i < j && j >= 1) {
			getBracketPerms(s + ")", i, j - 1, result);
		}

	}

	public static ArrayList<String> getPermBaseAndBuild(String s) {
		ArrayList<String> result = new ArrayList<String>();
		// if(s == null) return null;
		if (s.length() == 0) {
			result.add("");
			return result;
		}

		char c = s.charAt(0);
		String reducedString = s.substring(1);
		ArrayList<String> partials = getPermBaseAndBuild(reducedString);
		// now for each string insert c at every location

		for (String word : partials) {
			for (int j = 0; j <= word.length(); j++) {
				String newWord = insertCharAt(word, c, j);
				result.add(newWord);
			}
		}

		return result;
	}

	private static String insertCharAt(String s, char c, int i) {
		// insert c at index i
		String before = s.substring(0, i);
		String after = s.substring(i, s.length());
		return before + c + after;
	}

	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s.isEmpty()) {
			result.add("");
			return result;
		} else {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				String before = s.substring(0, i);
				String after = s.substring(i + 1, s.length());
				ArrayList<String> partials = getPerms(before + after);

				for (String word : partials) {
					// Add Character 'c' to each of the existing permutations
					// notice we don't clone and add
					word = c + word;
					result.add(word);

				}
			}
			return result;
		}
	}

	// ArrayList<ArrayList<Integer>> result = new
	// ArrayList<ArrayList<Integer>>();

	public static ArrayList<ArrayList<Integer>> powerSet(
			ArrayList<Integer> input) {
		ArrayList<ArrayList<Integer>> result = null;

		// powerset is all subsets of a set
		if (input.size() == 0) {
			// subset of an empty set is an empty set
			result = new ArrayList<ArrayList<Integer>>();
			result.add(new ArrayList<Integer>());
			return result;
		}
		for (int i = 0; i < input.size(); i++) {
			int removedSet = input.get(i);
			input.remove(i);
			result = powerSet(input);
			// add itself to clone of all existing sets in results and also
			// itself
			ArrayList<ArrayList<Integer>> clonedSets = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> jList : result) {
				ArrayList<Integer> listWithRemovedSet = new ArrayList<Integer>();
				listWithRemovedSet.addAll(jList);
				listWithRemovedSet.add(removedSet);
				clonedSets.add(listWithRemovedSet);
			}
			// System.out.println("Cloned sets are :" + clonedSets.toString());
			result.addAll(clonedSets);

		}
		return result;

	}

	public static Integer maxContiguousSum(int[] a) {
		/*
		 * Kadane's algorithm: Max contiguous sum is: if i = 0 then a[i] else
		 * max{a[i], previousSum + a[i]}
		 */
		if (a.length == 0) {
			return null;
		}
		int sum = a[0];
		int maxSum = a[0];
		for (int i = 1; i < a.length; i++) {
			sum = Math.max(a[i], sum + a[i]);
			if (maxSum < sum) {
				maxSum = sum;
			}
		}
		return maxSum;

	}

	public static String longestPalindrome(String s) {
		String longestPalindrome = s.substring(0, 1);
		for (int i = 1; i < s.length(); i++) {
			// System.out.println(s);
			// System.out.println("i: " + i);
			String oddLength = isPalindrome(s, i, i);
			String evenLength = isPalindrome(s, i, i + 1);
			if (oddLength.length() > longestPalindrome.length()) {
				longestPalindrome = oddLength;

			} else if (evenLength.length() > longestPalindrome.length()) {
				longestPalindrome = evenLength;
			}

			// System.out.println("longest: " + longestPalindrome);
		}
		return longestPalindrome;
	}

	public static String isPalindrome(String sub, int left, int right) {
		// left and right will grow from center
		while (left >= 0 && right < sub.length() - 1
				&& sub.charAt(left) == sub.charAt(right)) {
			left--;
			right++;
		}
		// System.out.println("l: " + left + " r: " + right);
		if (left < 0) {
			left = 0;
		} else if (left >= sub.length() - 1) {

			return sub.substring(left, right);

		}
		return sub.substring(left + 1, right);
	}

	public static int findIndex(int[] a, int left, int right, int x) {

		if (left > right) {
			return -1;
		}

		// search in the sorted array first
		// else x must be in the other half
		int mid = (left + right) / 2;

		if (x == a[mid]) {
			return mid;
		}
		if (a[left] < a[mid]) {
			// left half is sorted
			if (x >= a[left] && x < a[mid]) {
				findIndex(a, left, mid - 1, x);// search left
			} else {// search right
				findIndex(a, mid + 1, right, x);
			}

		} else if (a[mid] < a[right]) {
			// right is sorted
			if (x > a[mid] && x < a[right]) {
				// search right
				findIndex(a, mid + 1, right, x);
			} else {
				// search left
				findIndex(a, left, mid - 1, x);
			}
		} else if (a[mid] == a[left]) {
			// left half has same element
			if (a[mid] != a[right]) {
				findIndex(a, mid + 1, right, x);// search right
			} else {// search both halves
				int ans = findIndex(a, left, mid - 1, x);
				if (ans == -1) {
					return findIndex(a, mid + 1, right, x);
				}
			}
		}
		return -1;

	}

	private static String sortString(String str) {
		Arrays.sort(str.toCharArray());
		return str;
	}

	public static void anagramsTogether(String[] arr) {// array with anagrams
														// next to each other
		HashMap<String, ArrayList<String>> sortedMap = new HashMap<String, ArrayList<String>>();
		for (String s : arr) {
			String sortedString = sortString(s);
			if (!sortedMap.containsKey(sortedString)) {
				// first time
				sortedMap.put(sortedString, new ArrayList<String>());
			}

			// add in existing list
			sortedMap.get(sortedString).add(s);

		}
		// reconstruct array with anagrams next to each other
		int index = 0;
		for (String key : sortedMap.keySet()) {
			ArrayList<String> values = sortedMap.get(key);
			for (String s : values) {
				arr[index] = s;
				index++;
			}
		}
	}
}
