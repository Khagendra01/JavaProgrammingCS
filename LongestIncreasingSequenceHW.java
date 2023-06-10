import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Returns the length of the longest increasing sequence
 */
public class LongestIncreasingSequenceHW {
	public static int lis1(int[] A) {
		int[] T = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			T[i] = 1;
			for (int j = 0; j < i; j++)
				if (A[j] < A[i] && T[i] < T[j] + 1)
					T[i] = T[j] + 1;
		}

		System.out.println("Sequence: ") ;

		return max(T);
	}

	public static int max(int[] T) {
		int maxSoFar = T[0];
		for (int val : T)
			if (val > maxSoFar)
				maxSoFar = val;

		return maxSoFar;
	}

	/*
	 * Returns the length of the longest increasing sequence and prints the actual
	 * sequence
	 */
	public static int lis2(int[] A) {
		int[] T = new int[A.length];
		int[] prev = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			T[i] = 1;
			prev[i] = -1;

			for (int j = 0; j < i; j++)
				if (A[j] < A[i] && T[i] < T[j] + 1) {
					T[i] = T[j] + 1;
					prev[i] = j;
				}
		}

		System.out.println("Sequence: " + getSequence(prev, A));

		return max(T);
	}

	private static String getSequence(int[] prev, int[] A) {
		int max = max(prev);
		for (int i = prev.length - 1; i > -1; i--) {
			if (prev[i] == max) {
				max = i;
				break;
			}
		}

		String sequenceString = "";

		while (max >= 0) {
			sequenceString = A[max] + " " + sequenceString;
			max = prev[max];
		}

		return sequenceString;
	}

	public static void main(String[] args) {
		int[] a = { 7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1 };
		System.out.println(Arrays.toString(a));
		System.out.println("Length: " + lis1(a));
		System.out.println("Length: " + lis2(a));

		a = new int[] { 7, 2, 0, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1, 11 };
		System.out.println(Arrays.toString(a));
		System.out.println("Length: " + lis1(a));
		System.out.println("Length: " + lis2(a));
	}
}
