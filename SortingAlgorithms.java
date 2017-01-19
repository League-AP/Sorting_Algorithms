
/*http://www.java2novice.com/java-sorting-algorithms*/

import java.util.Random;

public class SortingAlgorithms {
	public static final int SIZE = 30;

	public static int arr[] = new int[SIZE];

	public static Random randGen = new Random();

	public static void main(String[] args) {
		System.out.print("Unsorted: ");
		randomizeArray();
		printArray();
		System.out.println("Running Bubble Sort: ");
		System.out.print("Sorted: ");
		runBubbleSort();
		printArray();
		System.out.println();
		
		System.out.print("Unsorted: ");
		randomizeArray();
		printArray();
		System.out.println("Running Selection Sort: ");
		System.out.print("Sorted: ");
		runSelectionSort();
		printArray();
		System.out.println();
	
		System.out.print("Unsorted: ");
		randomizeArray();
		printArray();
		System.out.println("Running Insertion Sort: ");
		runInsertionSort();
		System.out.print("Sorted: ");
		printArray();
		System.out.println();
		
		System.out.print("Unsorted: ");
		randomizeArray();
		printArray();
		System.out.println("Running Quick Sort: ");
		runQuickSort(0, arr.length - 1);
		System.out.print("Sorted: ");
		printArray();
		System.out.println();
		
		System.out.print("Unsorted: ");
		randomizeArray();
		printArray();
		System.out.println("Running Merge Sort: ");
		runMergeSort(0, arr.length - 1);
		System.out.print("Sorted: ");
		printArray();
		System.out.println();
	}

	public static void randomizeArray() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randGen.nextInt(SIZE);
		}
	}

	public static void printArray() {
		for (int i : arr) {
			System.out.print(i + ", ");
		}

		System.out.println();
	}

	public static boolean isArraySorted() {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static void runBubbleSort() {
		int temp = 0;
		while (!isArraySorted()) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}	
	}

	public static void runSelectionSort() {

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++){
				if (arr[j] < arr[index]){
					index = j;
				}
			}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
	}
	
	public static void runInsertionSort(){		
		int temp;
        for (int i = 1; i < arr.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
	}
	
	public static void runQuickSort(int low, int high){
        int i = low;
        int j = high;
        
        int temp = 0;
        int pivot = arr[low + (high - low) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
            	temp = arr[i];
            	arr[i] = arr[j];
            	arr[j] = temp;
    
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (low < j){
            runQuickSort(low, j);
        }
        if (i < high){
        	runQuickSort(i, high);
        }
	}
	
	public static void runMergeSort(int low, int high){
		int[] tempArr = new int[arr.length];
		
		if (low < high) {
            int middle = low + (high - low) / 2;
            
            runMergeSort(low, middle);
            runMergeSort(middle + 1, high);
            
            for (int i = low; i <= high; i++) {
            	tempArr[i] = arr[i];
            }
            int i = low;
            int j = middle + 1;
            int k = low;
            while (i <= middle && j <= high) {
                if (tempArr[i] <= tempArr[j]) {
                    arr[k] = tempArr[i];
                    i++;
                } else {
                    arr[k] = tempArr[j];
                    j++;
                }
                k++;
            }
            while (i <= middle) {
                arr[k] = tempArr[i];
                k++;
                i++;
            }
        }
	}
	
	
}
