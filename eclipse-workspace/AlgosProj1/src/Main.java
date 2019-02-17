import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;

public class Main {
	InsertionSort i_sort = new InsertionSort();
	MergeSort m_sort = new MergeSort();
	InPlaceQuickSort IQ_sort = new InPlaceQuickSort();
	ModifiedQuickSort modQ_sort = new ModifiedQuickSort();

	public static void main(String[] args) {
		int arraySize[] = { 500, 1000, 2000, 4000, 5000, 10000, 20000, 30000, 40000, 50000 };
		long start, end;
		InsertionSort i_sort = new InsertionSort();
		InPlaceQuickSort IQ_sort = new InPlaceQuickSort();
		ModifiedQuickSort modQ_sort = new ModifiedQuickSort();
		MergeSort m_sort = new MergeSort();
		int avg = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				//
				System.out.println("\n round -- " + (j + 1));
				RandomNumbersGen randomNumbersGen = new RandomNumbersGen();
				int[] arr = randomNumbersGen.RandomArray(arraySize[i]);
//				Arrays.sort(arr);
				Arrays.sort(new int[][] { arr }, Collections.reverseOrder());
				int insertion_array[] = arr;
				int merge_array[] = arr;
				int quick_array[] = arr;
				int mod_merge_array[] = arr;
				// Arrays.sort(new int[][]{arr}, Collections.reverseOrder()); Arrays.sort(new
				// int[][]{arr});
				System.out.println("\nInsertion Sort times");
				start = System.nanoTime();
				i_sort.sort(insertion_array);
				end = System.nanoTime();
				System.out.println((end - start));
				System.out.println("\nMerge Sort times");
				start = System.nanoTime();
				m_sort.sort(merge_array, 0, merge_array.length - 1);
				end = System.nanoTime();
				System.out.println((end - start));
				System.out.println("\nquick Sort times");
				start = System.nanoTime();
				IQ_sort.sort(quick_array, 0, arr.length - 1);
				end = System.nanoTime();
				System.out.println((end - start));
				System.out.println("\nmodified quick Sort times");
				start = System.nanoTime();
				end = System.nanoTime();
				System.out.println((end - start));
			}
		}
	}
}
