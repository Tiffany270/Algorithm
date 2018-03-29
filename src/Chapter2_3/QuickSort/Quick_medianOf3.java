package Chapter2_3.QuickSort;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick_medianOf3 extends Example {

	/*
	 * ���������µ���ȡ���з� ʹ���������һС����Ԫ�ص���λ�����з�����--����ȡ����С��Ϊ3���ô�С���е�Ԫ�����з�
	 * ��˼���з��õ�Ԫ������ȡ����
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
		swap(a, lo, m);//lo��m������lo�Ѿ����ǵ�һ��Ԫ���ˣ�ע���������������Ͳ����Ǵӵ�һ����ʼ��

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
	 * �з�������֡�Ϊ�з֣� 1.�Ƚ�a[lo]��Ϊ�з�Ԫ��k������i������ˣ�j�����Ҷˡ�
	 * 2.�ƶ�������Ϊ��a[i]��kС��a[j]��k�󡣽���a[i]��a[j]���ƶ����һ��i���ܵ�����j���ܵݼ���
	 */
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;// i�ƶ���ʱ�򲢲���lo��λ�ö���lo�ĺ�һ����jͬ����ǰһ�������һ������
		Comparable k = a[lo];
		while (true) {

			while (less(a[++i], k)) {
				if (i == hi) {
					break;
				}

			}
			while (less(k, a[--j])) {
				if (j == lo) {// j==lo�������
					break;
				}
			}
			if (i >= j)
				break;// ��ָ��i��j����ʱ��ѭ���˳�
			exch(a, i, j);// ����a[i]��a[j]��ͨ����������Ԫ��

		}
		exch(a, lo, j);// ����a[lo]��a[j]

		return j;// ����j��λ�þ���Ҫ���зֵ�λ��
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);

	}
}
