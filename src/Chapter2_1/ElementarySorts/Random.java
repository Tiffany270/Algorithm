package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.StdRandom;

public class Random {

	public static void shuffle(Object[] a) {

		int N = a.length;
		for (int i = 0; i < N; i++) {
			//key是产生的随机数，交换a[i]和a[随机数]
			int r = StdRandom.uniform(i + 1);
			exch(a, i, r);
		}
	}

	private static void exch(Object[] a, int i, int r) {
		// ...
	}

}
