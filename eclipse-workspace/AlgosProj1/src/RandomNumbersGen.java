import java.util.Arrays;
import java.util.Random;

public class RandomNumbersGen {
	public static int[] RandomArray(int size) {
		int[] randomNumbers = new int[size];
		Random rand = new Random();

		for (int i = 0; i < randomNumbers.length; i++) {
			int n = rand.nextInt(50000);
			randomNumbers[i] = n;
		}
		// return randomNumbers;

		Arrays.sort(randomNumbers);

		for (int i = 0; i < randomNumbers.length / 2; i++) {
			int temp = randomNumbers[i];
			randomNumbers[i] = randomNumbers[randomNumbers.length - i - 1];
			randomNumbers[randomNumbers.length - i - 1] = temp;
		}
		return randomNumbers;
	}
}
