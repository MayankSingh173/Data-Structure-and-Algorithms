package sorting;

/*
 * Time complexity -> O(nLogn)...Logn for create and building the heapify and n for traversing the 
 * elements
 * 
 * Space complexity -> O(1)
 */

public class Heap {
	public static void main(String args[]) {
		int arr[] = {9,8,7,6,-5,0,-1,-3,-4};
		
		sort(arr);
		
		for(int elem: arr) System.out.print(elem+" ");
	}
	
	public static void sort(int[] arr) {
		int n = arr.length;
		
		//creating a heap
		for(int i = n/2-1 ; i>=0; i--) {
			heapify(arr, n, i);
		}
		
		// One by one extract an element from heap
		for(int i = n-1 ; i>=0; i--) {
			
			//swap ist with the last i.e. i
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			//call the heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}
	
	public static void heapify(int[] arr, int n, int i) {
		
		int largest = i; //considering parent node as largest
		int left = 2*i+1; //index of left child node
		int right = 2*i+2; //index of right child node
		
		//updating the largest node
		if(left < n && arr[left] > arr[largest]) largest = left;
		
		if(right < n && arr[right] > arr[largest]) largest = right;
		
		//if the largest is not the parent node then we have to swap and heapify the child node
		if(largest != i) {
			//swap
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, n, largest);
		}
		
	}
}
