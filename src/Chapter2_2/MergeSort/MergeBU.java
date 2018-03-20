package Chapter2_2.MergeSort;

import java.util.Arrays;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;

public class MergeBU extends Example {

	/*
	 * 自底向上归并排序 时间复杂度为0(NlogN) 此排序会多次遍历整个数组，根据子数组的大小进行两两归并。 子数组的大小sz初始值为1，每次加倍
	 * 最后一个子数组的大小只有在数组大小是sz的偶数倍的时候才会等于sz
	 */

	private static Comparable[] aux;

	public static void merge(Comparable[] a, int lo, int mid, int hi) {

		int i = lo, j = mid + 1;// i是左边，j是右边
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];// 将a复制到aux里

		}

		for (int k = lo; k <= hi; k++) {// 用左边左边要递增，用右边右边要递增
			if (i > mid) {
				a[k] = aux[j++];
			} // 左半边用尽取右半边的元素
			else if (j > hi) {
				a[k] = aux[i++];
			} // 右半边用尽取左半边的元素
			else if (less(aux[j], aux[i])) {// 当前元素小于左边的当前元素则取右半边的元素
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}

		}

	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];

		/*
		 * 外循环控制sz sz < N:从头到尾遍历分割整个数组 。 sz = sz + sz:sz成倍数增长1，2，4，8....
		 */
		for (int sz = 1; sz < N; sz = sz + sz) {

			/*
			 * 内循环控制每个sz长度内对已经分割的数组进行归并排序。 排序后递增直至整个数组完成。
			 * lo<N-sz：从后往前看试想，因为遍历是根据sz增长的，怎么保证它停止呢，N-sz可以保证最后一趟超了便停止了。
			 */
			for (int lo = 0; lo < N - sz; lo += sz + sz) {

				int mid = lo + sz - 1;// sz在此循环内不变的，-1是因为是数组从零开始，想想怎么找中间值

				// min能选择两个数种小的数，作用是如果长度不够sz的情况下能选最后的数作为结束。
				// lo + sz + sz - 1：sz+sz就是增长间距，-1也是因为数组索引从零开始。
				merge(a, lo, mid, Math.min(lo + sz + sz - 1, N - 1));
				System.out.println(Arrays.toString(a));
			}
		}
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);

	}

}
