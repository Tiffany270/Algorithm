package Chapter2_4.PriorityQueue;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HeapSort {

	// This class should not be instantiated.
	private HeapSort() {
	}

	/**
	 * 堆排序分为两个阶段： 1.堆构造阶段：将原始数组重新安排进一个堆中
	 * 2.堆下沉阶段：从队中按递减顺序取出所有元素并得到排序结果
	 * （而此时具体为将堆中的最大元素删除，然后放入堆中缩小后数组中空出的元素，下沉第一个元素。 
	 * Rearranges
	 * the array in ascending order, using the natural order.
	 * 
	 * @param pq
	 *            the array to be sorted
	 */
	public static void sort(Comparable[] pq) {
		int n = pq.length;
		for (int k = n / 2; k >= 1; k--)// 开始时只需要扫描数组中一半的元素，因为可以跳过大小为1的子堆
			sink(pq, k, n);
		while (n > 1) {
			exch(pq, 1, n--);
			sink(pq, 1, n);
		}
	}

	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/

	private static void sink(Comparable[] pq, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(pq, j, j + 1))
				j++;
			if (!less(pq, k, j))
				break;
			exch(pq, k, j);
			k = j;
		}
	}

	/***************************************************************************
	 * Helper functions for comparisons and swaps. Indices are "off-by-one" to
	 * support 1-based indexing.
	 ***************************************************************************/
	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}

	/**
	 * Reads in a sequence of strings from standard input; heapsorts them; and
	 * prints them to standard output in ascending order.
	 *
	 * @param args
	 *            the command-line arguments
	 */
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Heap.sort(a);
		show(a);
	}
}
