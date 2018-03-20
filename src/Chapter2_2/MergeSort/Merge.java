package Chapter2_2.MergeSort;

import java.util.Arrays;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;

public class Merge extends Example {

	/*
	 * ԭ�ع鲢�ĳ��󷽷�+�Զ����µĹ鲢����
	 * �鲢�㷨���᳤���뽻��Ԫ�أ��Ǹ��ȶ����㷨��
	 */

	@SuppressWarnings("rawtypes")

	private static Comparable[] aux;

	/*
	 * ԭ�ع鲢�ĳ��󷽷� ����һ������ָ�Ϊ��������ͬ��������������鲢�������������С�
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {

		int i = lo, j = mid + 1;// i����ߣ�j���ұ�
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];// ��a���Ƶ�aux��

		}

		for (int k = lo; k <= hi; k++) {// ��������Ҫ���������ұ��ұ�Ҫ����
			if (i > mid) {
				a[k] = aux[j++];
			} // �����þ�ȡ�Ұ�ߵ�Ԫ��
			else if (j > hi) {
				a[k] = aux[i++];
			} // �Ұ���þ�ȡ���ߵ�Ԫ��
			else if (less(aux[j], aux[i])) {// ��ǰԪ��С����ߵĵ�ǰԪ����ȡ�Ұ�ߵ�Ԫ��
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}

		}

	}

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];// һ���Է���ռ�
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;//����±�
		
		int mid = lo + (hi - lo) / 2;//ȷ���м�ֵ
		sort(a, lo, mid);// ���������
		sort(a, mid + 1, hi);// ���ұ�����
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
