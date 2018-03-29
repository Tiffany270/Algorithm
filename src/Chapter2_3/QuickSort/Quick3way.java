package Chapter2_3.QuickSort;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3way extends Example {

	/*
	 * 三向切分的快速排序 如果出现重复元素怎么办，此排序能比其他方法在包括重复元素很多的实际应用中更快。
	 */
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	/*
	 * 维护指针lt，a[lo..lt+1]中的元素都小于k。 
	 * 维护指针i，a[lt..i-1]中元素都等于k。
	 * 维护指针gt,a[gt+1..hi]中元素都大于k。
	 * 每次切分的lo=v都是当前子数组的第一个，是拿来比较的，不用多想了。
	 * 如：01164373223986
	 * 分为0 11 64373223986
	 * 第二次排序 0自排 11不变，64373223986--》以6为lo=v,433223 66 897以此类推
	 */
	static int c=1;
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi < lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) {// -->a[i]<v,lt和i递增
				exch(a, lt++, i++);
			} else if (cmp > 0) {// -->a[i]>v,gt递减并且a[gt]和a[i]交换位置
				exch(a, i, gt--);
			} else// -->a[i]=v，是重复元素，直接i递增。
				i++;
		} // 这里开始a[lo..lt+1]<v=a[lt..i-1]<gt,a[gt+1..hi]
		System.out.print("第"+c+"次排序:");
		show(a);
		System.out.println();
		c++;
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		System.out.print("排序前：");
		show(a);
		System.out.println();
		System.out.println("--------开始排序---------");
		sort(a);
		assert isSorted(a);
		System.out.print("排序后:");
		show(a);

	}

}
