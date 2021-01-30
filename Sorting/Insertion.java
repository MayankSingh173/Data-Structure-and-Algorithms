package sorting;

/*
 
Algorithm : 
To sort an array of size n in ascending order:
1: Iterate from arr[1] to arr[n] over the array.
2: Compare the current element (key) to its predecessor.
3: If the key element is smaller than its predecessor, compare it to the elements before. 
Move the greater elements one position up to make space for the swapped element.

Time Complexity: O(n*2)

Auxiliary Space: O(1)

Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
And it takes minimum time (Order of n) when elements are already sorted.

Algorithmic Paradigm: Incremental Approach

Sorting In Place: Yes

Stable: Yes

Online: Yes

Uses: Insertion sort is used when number of elements is small. It can also be useful when input array
is almost sorted, only few elements are misplaced in complete big array.

*/
public class Insertion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {9,8,7,6,2,0,-1,-3,-4};
		
//		sort(arr);
		
		//By recursion
		recursiveSort(arr, arr.length);
		
		for(int elem: arr) System.out.print(elem+" ");
	}
	
	public static void sort(int[] arr) {
		
		for(int i=1 ; i<arr.length ; i++) {
			int key = arr[i];
			
			int j = i-1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
	}
	
	public static void recursiveSort(int[] arr, int n) {
		
		//Base case
		if(n <= 1) return;
		
		//sort the sub-array
		recursiveSort(arr, n-1);
		
		
		//insert the last element at correct position
		int key = arr[n-1];
		
		int j = n-2;
		
		while(j >= 0 && arr[j] > key) {
			arr[j+1] = arr[j];
			j--;
		}
		
		arr[j+1] = key;
	}
}
