package Chapter2_3.QuickSort;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick_select extends Example {
	/*
	 * ����ѡ�� ������δ�����������Ѱ�ҵ�kС/��k���Ԫ��
	 * lo---j----hi
	 * �зֺ�j��Ŀ��Ԫ�رȽϣ����k��������������hi=j-1,����������ң��ұ���lo=j+1,�������ұ���
	 * �ݹ飬ֱ���ҵ�Ϊֹ��
	 *  Worst-case performance ��(n2) 
	 *  Best-case performance ��(n)
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
		System.out.println();
		System.out.println(select(a,3));

	}

}
