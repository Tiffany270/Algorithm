package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.In;

public class Selection extends Example {
	/*
	 * ѡ������ �ҵ���������С���Ǹ�Ԫ�أ������������һ��Ԫ�ؽ���λ�ã������һ��Ԫ�ؾ�����СԪ�������Լ�����
	 * ��ʣ�µ�Ԫ�����ҵ���С��Ԫ�أ������͵ڶ���Ԫ�ؽ���λ�ã�������� ����ʱ��������޹�
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
			exch(a, i, min);// ������ʵ��û����һ����ѭ����ѡ����С�ĲŽ�����
		}
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);

	}

}
