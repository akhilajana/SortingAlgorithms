import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InPlaceQuickSort {
	static void sort(int arr[], int l, int r) {
		if (r > l) {
			int i = l, j = r, tmp;
			int p = ThreadLocalRandom.current().nextInt(l, r + 1);
			int v = arr[p]; // pivot
			do {
				while (arr[i] < v) {
					i++;
				}
				while (arr[j] > v) {
					j--;
				}
				if (i <= j) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					i++;
					j--;
				}
			} while (i <= j);
			if (l < j) {
				sort(arr, l, j);
			}
			if (i < r) {
				sort(arr, i, r);
			}
		}
	}
}
