package sorting;

/*
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent 
elements if they are in wrong order. 
 
Optimized Implementation:
The above function always runs O(n^2) time even if the array is sorted. It can be optimized by 
stopping the algorithm if inner loop didn’t cause any swap.
 
 
Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.

Best Case Time Complexity: O(n). Best case occurs when array is already sorted.

Auxiliary Space: O(1)

Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 */

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {9,8,7,6,2,0,-1,-3,-4};
		
		//sort(arr);
		
		//By recursion
		recursiveSort(arr, arr.length);
		
		for(int elem: arr) System.out.print(elem+" ");
	}
	
	public static void sort(int[] arr) {
		
		int n = arr.length;
		
		boolean swapped = false;
		for(int i=0; i<n; i++) {
			swapped = false;
			for(int j = 0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					
					//swap j and j+1
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			
			if(!swapped) break;
		}
	}
	
	//Recursion
	public static void recursiveSort(int arr[],int n) {
		
		//base case
		if(n == 1) return;
		
		//Do one pass of bubble sort. This will push the largest element to the end
		
		boolean swapped = false;
		
		for(int j = 0; j<n-1; j++) {
			if(arr[j] > arr[j+1]) {
				//swap j and j+1
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				swapped = true;
			}
		}
		
		if(!swapped) return;
		else recursiveSort(arr, n-1);
	}
}
