package Chapter2_3.QuickSort;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick_select extends Example {
	/*
	 * 快速选择 用来在未排序的数组中寻找第k小/第k大的元素
	 * lo---j----hi
	 * 切分后，j和目标元素比较，如果k在左边子数组里，则hi=j-1,继续在左边找，右边则lo=j+1,继续在右边找
	 * 递归，直到找到为止。
	 *  Worst-case performance О(n2) 
	 *  Best-case performance О(n)
	 *  Average performance O(n)
	 */

	public static Comparable select(Comparable[] a, int k) {

		StdRandom.shuffle(a);
		int lo = 0, hi = a.length - 1;
		while (hi > lo) {
			int j = partition(a, lo, hi);
			if (j < k) {
				lo = j + 1;
			} else if (j > k) {
				hi = j - 1;
			} else

				return a[k];
		}
		return a[k];
	}

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
		System.out.println();
		System.out.println(select(a,3));

	}

}
