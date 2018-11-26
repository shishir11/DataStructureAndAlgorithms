package algo;

public class MyQuickSort {
	 private int array[];
	    private int length;
	 
	    public void sort(int[] inputArr) {
	         
	        if (inputArr == null || inputArr.length == 0) {
	            return;
	        }
	        this.array = inputArr;
	        length = inputArr.length;
	        quickSort(0, length - 1);
	    }
	 
	    private void quickSort(int lowerIndex, int higherIndex) {
	         
	        int startingPosition = lowerIndex;
	        int lastPosition = higherIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	        // Divide into two arrays
	        while (startingPosition <= lastPosition) {
	            /**
	             * In each iteration, we will identify a number from left side which 
	             * is greater then the pivot value, and also we will identify a number 
	             * from right side which is less then the pivot value. Once the search 
	             * is done, then we exchange both numbers.
	             */
	            while (array[startingPosition] < pivot) {
	                startingPosition++;
	            }
	            while (array[lastPosition] > pivot) {
	                lastPosition--;
	            }
	            if (startingPosition <= lastPosition) {
	                exchangeNumbers(startingPosition, lastPosition);
	                //move index to next position on both sides
	                startingPosition++;
	                lastPosition--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < lastPosition)
	            quickSort(lowerIndex, lastPosition);
	        if (startingPosition < higherIndex)
	            quickSort(startingPosition, higherIndex);
	    }
	 
	    private void exchangeNumbers(int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	     
	    public static void main(String a[]){
	         
	        MyQuickSort sorter = new MyQuickSort();
	        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
	        sorter.sort(input);
	        for(int i:input){
	            System.out.print(i);
	            System.out.print(" ");
	        }
	    }
}
