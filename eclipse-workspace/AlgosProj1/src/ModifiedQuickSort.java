import java.util.Arrays;

public class ModifiedQuickSort {
	static int[] modified_quicksort(int[] sequence) {
		m_quicksort(sequence, 0, sequence.length - 1);
		return sequence;
	}

	private final static int CUT_OFF = 10;

	static void m_quicksort(int[] a, int low, int high) {
		if (low + CUT_OFF > high) {
			InsertionSort insertionSort = new InsertionSort();
			insertionSort.sort(a);
		} else {
			int middle = (low + high) / 2;
			if (a[middle] < a[low])
				s_references(a, low, middle);
			if (a[high] < a[low])
				s_references(a, low, high);
			if (a[high] < a[middle])
				s_references(a, middle, high);
			s_references(a, middle, high - 1);
			int pivot = a[high - 1];
			int i, j;
			for (i = low, j = high - 1;;) {
				while (a[++i] < pivot)
					;

				while (pivot < a[--j])
					;
				if (i >= j)
					break;
				s_references(a, i, j);
			}
			s_references(a, i, high - 1);
			m_quicksort(a, low, i - 1);
			m_quicksort(a, i + 1, high);
		}
	}

	public static void s_references(int[] a, int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
}
