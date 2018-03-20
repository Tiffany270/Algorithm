package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.In;

public class Insertion extends Example {
	/*插入排序
	 * 只会交换相邻的元素
	 * 插入排序 为了给要插入的元素腾出空间，需要将其余所有元素在插入之前都向右移动一位
	 * 当前索引左边的所有元素都是有序的，但是当索引到达数组的右端时，数组排序就完成了。
	 */

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
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
