/*
 * A sub-array has one number of some continuous numbers.
 * Given an integer array with positive numbers and negative numbers, get the maximum sum of all sub-arrays.
 * Time complexity should be O(n).
 */
public class Question3 {

	public static int max(int x, int y) {
		return (y > x) ? y : x;
	}

	public static int maxSubArraySum(int a[]) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < a.length; i++) {
			curr_max = max(a[i], curr_max + a[i]);
			max_so_far = max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int max_sum = maxSubArraySum(a);
		System.out.println("Max = " + max_sum);
	}
}
