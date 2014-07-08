class Solution {
    public static void find_deviation(Integer[] v, Integer d) {

    	int maxDeviation = 0;
		for (int j = 0; j < v.length - d; j++) {
			int pos = j + 1;
			int min = 0;
			int max = 0;
			for (int i = 0; i < d; i++) {
				if (v[pos] > max) max = v[pos];
				if (v[pos] < min || min == 0) min = v[pos];
				pos++;

			}
			int diff = max - min;
			if (diff > maxDeviation) maxDeviation = diff;
		}
		System.out.println(maxDeviation);
	}
}