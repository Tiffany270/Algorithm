package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.StdRandom;

public class Random {

	public static void shuffle(Object[] a) {

		int N = a.length;
		for (int i = 0; i < N; i++) {
			//key�ǲ����������������a[i]��a[�����]
			int r = StdRandom.uniform(i + 1);
			exch(a, i, r);
		}
	}

	private static void exch(Object[] a, int i, int r) {
		// ...
	}

}
