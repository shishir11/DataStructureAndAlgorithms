package algo;

public class MyBinarySearch {

	static String binarySearchInUnSortedArray(int arr[], int n, int x) {
		// 1st comparison
		if (arr[n - 1] == x)
			return "Found";

		int backup = arr[n - 1];
		arr[n - 1] = x;

		// no termination condition and thus
		// no comparison
		for (int i = 0;; i++) {
			// this would be executed at-most n times
			// and therefore at-most n comparisons
			if (arr[i] == x) {
				// replace arr[n-1] with its actual element
				// as in original 'arr[]'
				arr[n - 1] = backup;

				// if 'x' is found before the '(n-1)th'
				// index, then it is present in the array
				// final comparison
				if (i < n - 1)
					return "Found";

				// else not present in the array
				return "Not Found";
			}
		}
	}

	public int binarySearchInSortedArray(int[] inputArr, int key) {

		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 6, 1, 5, 8 };
		int length = arr.length;
		int key = 1;
		//System.out.println(binarySearchInUnSortedArray(arr, length, key));

		MyBinarySearch mbs = new MyBinarySearch();
		int[] arr1 = { 2, 4, 6, 8, 10, 12, 14, 16 };
		System.out.println("Key 14's position: " + mbs.binarySearchInSortedArray(arr1, 14));
		int[] arr2 = { 6, 34, 78, 123, 432, 900 };
		System.out.println("Key 432's position: " + mbs.binarySearchInSortedArray(arr2, 432));

	}

}
