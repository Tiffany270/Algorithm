package Chapter2_2.MergeSort;

import java.util.Arrays;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;

public class MergeBU extends Example {

	/*
	 * �Ե����Ϲ鲢���� ʱ�临�Ӷ�Ϊ0(NlogN) ��������α����������飬����������Ĵ�С���������鲢�� ������Ĵ�Сsz��ʼֵΪ1��ÿ�μӱ�
	 * ���һ��������Ĵ�Сֻ���������С��sz��ż������ʱ��Ż����sz
	 */

	private static Comparable[] aux;

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
		int N = a.length;
		aux = new Comparable[N];

		/*
		 * ��ѭ������sz sz < N:��ͷ��β�����ָ��������� �� sz = sz + sz:sz�ɱ�������1��2��4��8....
		 */
		for (int sz = 1; sz < N; sz = sz + sz) {

			/*
			 * ��ѭ������ÿ��sz�����ڶ��Ѿ��ָ��������й鲢���� ��������ֱ������������ɡ�
			 * lo<N-sz���Ӻ���ǰ�����룬��Ϊ�����Ǹ���sz�����ģ���ô��֤��ֹͣ�أ�N-sz���Ա�֤���һ�˳��˱�ֹͣ�ˡ�
			 */
			for (int lo = 0; lo < N - sz; lo += sz + sz) {

				int mid = lo + sz - 1;// sz�ڴ�ѭ���ڲ���ģ�-1����Ϊ��������㿪ʼ��������ô���м�ֵ

				// min��ѡ����������С������������������Ȳ���sz���������ѡ��������Ϊ������
				// lo + sz + sz - 1��sz+sz����������࣬-1Ҳ����Ϊ�����������㿪ʼ��
				merge(a, lo, mid, Math.min(lo + sz + sz - 1, N - 1));
				System.out.println(Arrays.toString(a));
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
