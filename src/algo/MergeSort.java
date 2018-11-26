package algo;

public class MergeSort {
	static int unsortedArray[] = { 100, 20, 15, 30, 5, 75, 40 };

	public static void main(String args[]) {
		// Print array before merge sort
		System.err.println("Array before sorting:");
		printArray(unsortedArray, 0, unsortedArray.length - 1);
		System.out.println("-----------------------------");

		mergeSort(0, unsortedArray.length - 1);

		System.out.println("-----------------------------");

		// Print array after sorting
		System.out.println("Array After sorting:");
		printArray(unsortedArray, 0, unsortedArray.length - 1);

	}

	// Recursive algorithm for merge sort
	public static void mergeSort(int start, int end) {
		int middle = (start + end) / 2;
		if (start < end) {
			// Sort left half
			mergeSort(start, middle);
			// Sort right half
			mergeSort(middle + 1, end);
			// Merge left and right half
			merge(start, middle, end);
		}

	}

	private static void merge(int start, int middle, int end) {
		// Initializing temp array and index
		int[] tempSortedArray = new int[unsortedArray.length];
		int tempArrayIndex = start;

		System.out.print("Before Merging:  ");
		printArray(unsortedArray, start, end);

		int startIndex = start;
		int middlePlusOne = middle + 1;

		// It will iterate until smaller list reaches to the end
		while (startIndex <= middle && middlePlusOne <= end) {
			if (unsortedArray[startIndex] < unsortedArray[middlePlusOne]) {
				tempSortedArray[tempArrayIndex++] = unsortedArray[startIndex++];
			} else {
				tempSortedArray[tempArrayIndex++] = unsortedArray[middlePlusOne++];
			}
		}

		// Copy remaining elements
		while (startIndex <= middle) {
			tempSortedArray[tempArrayIndex++] = unsortedArray[startIndex++];
		}
		while (middlePlusOne <= end) {
			tempSortedArray[tempArrayIndex++] = unsortedArray[middlePlusOne++];
		}

		// Copy tempArray to actual array after sorting
		for (int i = start; i <= end; i++) {
			unsortedArray[i] = tempSortedArray[i];
		}

		System.out.print("After merging:   ");
		printArray(tempSortedArray, start, end);
		System.out.println();
	}

	public static void printArray(int arr[], int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
