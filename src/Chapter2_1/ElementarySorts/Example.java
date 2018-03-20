package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*≈≈–ÚÀ„∑®¿‡ƒ£∞Â*/
public class Example {

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {

	}

	protected static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;

	}

	protected static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	protected static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + "");
		}
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
