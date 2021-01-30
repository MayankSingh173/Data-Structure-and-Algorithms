package sorting;

/*
QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given 
array around the picked pivot. There are many different versions of quickSort that pick pivot in 
different ways.

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.

The key process in quickSort is partition(). Target of partitions is, given an array and an element 
x of array as pivot, put x at its correct position in sorted array and put all smaller elements 
(smaller than x) before x, and put all greater elements (greater than x) after x. All this should 
be done in linear time.


Time Complexity -> 

worst case - O(n*n). This happens when partition function always chooses smallest or the largest
element in the array.

Average and best - O(nLogn)

Space complexity -> O(1) In-place

QuickSort is faster in practice, because its inner loop can be efficiently implemented on most 
architectures, and in most real-world data.

merge sort is generally considered better when data is huge and stored in external storage. 
*/


public class Quick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[] = {9,8,7,6,2,0,-1,-3,-4};
		
		sort(arr, 0, arr.length-1);
		
		for(int elem: arr) System.out.print(elem+" ");
	}
	
	public static void sort(int[] arr, int low, int high) {
		
		if(low < high) {
			
			/* pi is partitioning index, arr[pi] is  
            now at right place */
			int pi = partitionAsMiddle(arr, low, high);
			
			// Recursively sort elements before 
            // partition and after partition 
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}
	
	
	 /*This function takes last element as pivot, 
     places the pivot element at its correct 
     position in sorted array, and places all 
     smaller (smaller than pivot) to left of 
     pivot and all greater elements to right 
     of pivot */
	public static int partitionAsLastIndex(int[] arr, int low, int high) {
		int pivot = arr[high];
		
		// index of smaller element 
		int i = low-1;
		
		for(int j=low ; j<high; j++) {
			
			// If current element is smaller than the pivot 
			if(arr[j] < pivot) {
				i++;
				
				// swap i and j
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}
	
	public static int partitionAsMiddle(int[] arr, int low, int high) {
		
		//pivot as center
		int pivot = arr[(low+high)/2];
		
		while(low <= high) {
			
			//getting the element which is greater than pivot
			while(arr[low] < pivot) {
				low++;
			}
			
			//getting the element which is smaller than pivot
			while(arr[high] > pivot) {
				high--;
			}
			
			//swapping the elements
			if(low <= high) {
				
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				
				low++;
				high--;
			}
		}
		
		return low;
	}

}
