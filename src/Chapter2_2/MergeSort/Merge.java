package Chapter2_2.MergeSort;

import java.util.Arrays;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;

public class Merge extends Example {

	/*
	 * 原地归并的抽象方法+自顶向下的归并排序
	 * 归并算法不会长距离交换元素，是个稳定的算法。
	 */

	@SuppressWarnings("rawtypes")

	private static Comparable[] aux;

	/*
	 * 原地归并的抽象方法 将（一个数组分割为两个）不同的两个有序数组归并到第三个数组中。
	 */
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
		aux = new Comparable[a.length];// 一次性分配空间
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;//检查下标
		
		int mid = lo + (hi - lo) / 2;//确定中间值
		sort(a, lo, mid);// 将左边排序
		sort(a, mid + 1, hi);// 将右边排序
		merge(a, lo, mid, hi);
		System.out.println(Arrays.toString(a));

	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
		
	}

}
