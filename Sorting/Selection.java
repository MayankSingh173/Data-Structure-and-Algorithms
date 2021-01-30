package sorting;

/* Selection sort takes the minimum element from the  subarray and put it in the front of the array
 * 
 * Eg. 9 8 7 6 2
 * 
 * 1st iteration = arr[0..4] find the min num i.e 2 and swap with 0
 * arr -> 2 8 7 6 9
 *        .   
 * 
 * 2nd = arr[1..4] find the min num i.e. 6 ans swap with 1
 * arr -> 2 6 7 8 9
 *          .
 * 
 * 3rd = arr[2..4] min elem is 7
 * arr -> 2 6 7 8 9
 *            .
 * 
 *Sorting is taking place from starting
 * 
 * Time complexity -> O(n^2)
 * Space Complexity -> O(1)*/


public class Selection {
	public static void main(String args[]) {
		int arr[] = {9,8,7,6,2,0,-1,-3,-4};
		
		sort(arr);
		
		for(int elem: arr) System.out.print(elem+" ");
	}
	
	public static void sort(int[] arr) {
		for(int i=0 ; i<arr.length; i++) {
			int min = i;
			for(int j=i ; j<arr.length; j++) {
				if(arr[j] < arr[i]) min = j;
			}
			
			//swap
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
		}
	}
}
