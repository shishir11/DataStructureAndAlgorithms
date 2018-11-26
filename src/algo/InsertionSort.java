package algo;

import util.Util;

/**
 * Insertion sort is a simple sorting algorithm that works the way we sort
 * playing cards in our hands.
 * 
 * Algorithm // Sort an arr[] of size n insertionSort(arr, n) Loop from i = 1 to
 * n-1. ……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
 * 
 * @author shishir.sarkar
 *
 */
public class InsertionSort {
	void sort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6 };

		InsertionSort ob = new InsertionSort();
		ob.sort(arr);

		Util.printArray(arr);
	}
}
