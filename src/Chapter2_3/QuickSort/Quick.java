package Chapter2_3.QuickSort;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick extends Example {

	/*
	 * �������� �ݹ�ؽ�һ������ֳ����������飬�������ֶ��������� 
	 */

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	/*�з�������֡�Ϊ�з֣� 1.�Ƚ�a[lo]��Ϊ�з�Ԫ��k������i������ˣ�j�����Ҷˡ�
	 * 2.�ƶ�������Ϊ��a[i]��kС��a[j]��k�󡣽���a[i]��a[j]���ƶ����һ��i���ܵ�����j���ܵݼ���
	 * */
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;//i�ƶ���ʱ�򲢲���lo��λ�ö���lo�ĺ�һ����jͬ����ǰһ�������һ������
		Comparable k = a[lo];
		while (true) {

			while (less(a[++i], k)) {
				if (i == hi) {
					break;
				}

			}
			while (less(k, a[--j])) {
				if (j == lo) {//j==lo�������
					break;
				}
			}
			if (i >= j)
				break;//��ָ��i��j����ʱ��ѭ���˳�
			exch(a, i, j);//����a[i]��a[j]��ͨ����������Ԫ��

		}
		exch(a, lo, j);//����a[lo]��a[j]

		return j;//����j��λ�þ���Ҫ���зֵ�λ��
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);

	}
}
