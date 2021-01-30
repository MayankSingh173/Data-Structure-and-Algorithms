package sorting;

/*

Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves, calls 
itself for the two halves, and then merges the two sorted halves. The merge() function is used for 
merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and 
arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.
 
 
Time complexity -> θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides 
the array into two halves and takes linear time to merge two halves.

Auxiliary Space: O(n)
Algorithmic Paradigm: Divide and Conquer
Sorting In Place: No in a typical implementation
Stable: Yes
*/
public class Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[] = {9,8,7,6,2,0,-1,-3,-4};
		
		sort(arr, 0, arr.length-1);
		
		for(int elem: arr) System.out.print(elem+" ");
	}
	
	public static void sort(int[] arr, int l, int r) {
		
		if(l < r) {
			int mid = (l+r)/2;
			
			sort(arr,l,mid);
			sort(arr,mid+1,r);
			merge(arr,l,mid,r);
		}
	}
	
	public static void merge(int[] arr, int l, int m, int r) {
		
		//length of two sub-arrays
		int n1 = m-l+1;
		int n2 = r-m;
		
		//creating two sub-arrays that are going to be merge
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		//copying elements of array to L and R
		for(int i=0 ; i < n1; i++) {
			L[i] = arr[i+l];
		}
		
		for(int i=0; i<n2 ; i++) {
			R[i] = arr[m+1+i];
		}
		
		//index of both two sub-arrays
		int i=0, j=0;
		
		//index of forming array;
		int k = l;
		
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		//putting the remaining elements if any
		while(i < n1) {
			arr[k++] = L[i++];
		}
		
		while(j < n2) {
			arr[k++] = L[j++];
		}
	}

}
