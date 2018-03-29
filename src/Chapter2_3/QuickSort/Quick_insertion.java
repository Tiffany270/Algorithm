package Chapter2_3.QuickSort;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

public class Quick_insertion extends Example {

	/*
	 * 算法改进-切换到插入排序 对于小数组，快速排序慢于插入排序
	 */

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	// 改进的地方为if语句
	private static void sort(Comparable[] a, int lo, int hi) {
		double M = StdRandom.uniform(5, 15);
		if (hi <= lo + M) {
			insertionSort(a,lo,hi);
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }

	/*
	 * 切分这个【分】为切分： 1.先将a[lo]作为切分元素k并设置i在最左端，j在最右端。
	 * 2.移动的条件为：a[i]比k小，a[j]比k大。交换a[i]和a[j]，移动后的一方i才能递增，j才能递减。
	 */
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;// i移动的时候并不是lo的位置而是lo的后一个，j同理是前一个（最后一个）。
		Comparable k = a[lo];
		while (true) {

			while (less(a[++i], k)) {
				if (i == hi) {
					break;
				}

			}
			while (less(k, a[--j])) {
				if (j == lo) {// j==lo是冗余的
					break;
				}
			}
			if (i >= j)
				break;// 当指针i和j相遇时主循环退出
			exch(a, i, j);// 交换a[i]和a[j]，通过索引交换元素

		}
		exch(a, lo, j);// 交换a[lo]和a[j]

		return j;// 现在j的位置就是要被切分的位置
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);

	}
}
