package quicksort;

public class Quicksort {

	public static int sort(int[] numbers, int startIndex, int endIndex) {

		int numOfComparisons = sort(numbers, startIndex, endIndex, 0);
		return numOfComparisons;
	}

	public static int sort(int[] numbers, int startIndex, int endIndex, int numOfComparisons) {

		if (startIndex < endIndex) {
			int pivotIndex = partition(numbers, startIndex, endIndex);
			numOfComparisons = numOfComparisons + (endIndex - startIndex - 1);
			numOfComparisons = +sort(numbers, startIndex, pivotIndex, numOfComparisons);
			numOfComparisons = +sort(numbers, pivotIndex + 1, endIndex, numOfComparisons);
		}
		// System.out.println("numOfComparisons***: " + numOfComparisons);
		return numOfComparisons;
	}

	private static int partition(int[] numbers, int startIndex, int endIndex) {
		/*
		 * Case1.if pivot is first element of subarray then pivot =
		 * numbers[startIndex] Case2.if pivot is last element of subarray then
		 * pivot = numbers[endIndex], then exchange pivot element(i.e last
		 * element) with first element
		 * 
		 */

		/*
		 * Case1:(Base Case) int pivot = numbers[startIndex];
		 */
		/*
		 * Case 2: int pivot = numbers[endIndex-1];
		 * 
		 * swap(numbers,startIndex,endIndex-1);
		 * 
		 * 
		 */
		int middleIndex = (startIndex + endIndex) / 2;
		System.out.println("middleIndex: " + middleIndex);
		int pivot = medianOfThree(numbers[startIndex], numbers[endIndex - 1], numbers[middleIndex]);
		//Swap medianOfThree i.e pivot with first element of array
		if(pivot == numbers[endIndex-1]){
			swap(numbers,startIndex, endIndex-1);
		}
		else if(pivot == numbers[middleIndex]){
			swap(numbers,startIndex,middleIndex);
		}
		else pivot = numbers[startIndex];
		
		
		int i = startIndex + 1;
		for (int j = startIndex + 1; j < endIndex; j++) {
			if (numbers[j] < pivot) {// else numbers[j]>pivot so just increment
										// j // j
				// swap numbers[j] with leftmost element of right(greater than
				// pivot) array
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
			}
		}
		// swap numbers[startIndex
		// wihttp://community.jaspersoft.com/project/jaspersoft-dockerth
		// rightmost element of left(less than
		// pivot) array
		int temp = pivot;
		numbers[startIndex] = numbers[i - 1];
		numbers[i - 1] = temp;
		return i - 1;
	}
	
	private static void swap(int[] numbers, int firstIndex, int secondIndex){
		int temp = numbers[firstIndex];
		numbers[firstIndex] = numbers[secondIndex];
		numbers[secondIndex] = temp;
	}

	public static int medianOfThree(int a,int b, int c){
		/*		1. a greatest{ return larger  (b,c)
				2. b greatest{return larger (a,c)}
				3. c is greatest{return larger of (a,b)*/
				if(a>b){
					if(a>c){
						return b>c? b:c;
					}
					else {return a;}//a is middle
					
				}
				else{//b greater than a
					if(b>c){
						return a>c? a : c ;
						
					}
					else{ return b;} // b is middle
						
					}
	
				
			}
}
