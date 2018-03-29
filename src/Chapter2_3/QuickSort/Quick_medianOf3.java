package Chapter2_3.QuickSort;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick_medianOf3 extends Example {

	/*
	 * 快速排序下的三取样切分 使用子数组的一小部分元素的中位数来切分数组--》将取样大小设为3并用大小居中的元素来切分
	 * 意思是切分用的元素是先取样？
	 */

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int m = median3(a, lo, lo + (hi - lo) / 2, hi);
		swap(a, lo, m);//lo和m交换了lo已经不是第一个元素了，注意这里是索引，就不再是从第一个开始了

		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static void swap(Comparable[] a, int lo, int m) {
		Comparable t = a[lo];
		a[lo] = a[m];
		a[m] = t;

	}

	private static int median3(Comparable[] a, int i, int j, int k) {
		return (less(a[i], a[j]) ? 
			(less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i):
			(less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
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
