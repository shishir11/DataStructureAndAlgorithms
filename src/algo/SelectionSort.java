package algo;

import util.Util;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element 
 * (considering ascending order) from unsorted part and putting it at the beginning. The 
 * algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) 
from the unsorted subarray is picked and moved to the sorted subarray.
 * @author shishir.sarkar
 *
 */
public class SelectionSort {
	void sort(int arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;
			// Swap the found minimum element with the first
			// element
			Util.swap(arr, i, min_idx);
		}
	}

	public static void main(String[] args) {
		SelectionSort ob = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11,4,10,3,1 };
		ob.sort(arr);
		System.out.println("Sorted array");
		Util.printArray(arr);

	}

}
