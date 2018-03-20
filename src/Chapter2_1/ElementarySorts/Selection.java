package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.In;

public class Selection extends Example {
	/*
	 * 选择排序 找到数组中最小的那个元素，将它和数组第一个元素交换位置，如果第一个元素就是最小元素它和自己交换
	 * 在剩下的元素中找到最小的元素，将它和第二个元素交换位置，如此往复 运行时间和输入无关
	 */

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}

			}
			exch(a, i, min);// 这里其实是没结束一次内循环后选出最小的才交换的
		}
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);

	}

}
