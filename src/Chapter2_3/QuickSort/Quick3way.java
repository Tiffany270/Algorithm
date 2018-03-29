package Chapter2_3.QuickSort;

import Chapter2_1.ElementarySorts.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3way extends Example {

	/*
	 * �����зֵĿ������� ��������ظ�Ԫ����ô�죬�������ܱ����������ڰ����ظ�Ԫ�غܶ��ʵ��Ӧ���и��졣
	 */
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	/*
	 * ά��ָ��lt��a[lo..lt+1]�е�Ԫ�ض�С��k�� 
	 * ά��ָ��i��a[lt..i-1]��Ԫ�ض�����k��
	 * ά��ָ��gt,a[gt+1..hi]��Ԫ�ض�����k��
	 * ÿ���зֵ�lo=v���ǵ�ǰ������ĵ�һ�����������Ƚϵģ����ö����ˡ�
	 * �磺01164373223986
	 * ��Ϊ0 11 64373223986
	 * �ڶ������� 0���� 11���䣬64373223986--����6Ϊlo=v,433223 66 897�Դ�����
	 */
	static int c=1;
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi < lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) {// -->a[i]<v,lt��i����
				exch(a, lt++, i++);
			} else if (cmp > 0) {// -->a[i]>v,gt�ݼ�����a[gt]��a[i]����λ��
				exch(a, i, gt--);
			} else// -->a[i]=v�����ظ�Ԫ�أ�ֱ��i������
				i++;
		} // ���￪ʼa[lo..lt+1]<v=a[lt..i-1]<gt,a[gt+1..hi]
		System.out.print("��"+c+"������:");
		show(a);
		System.out.println();
		c++;
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		System.out.print("����ǰ��");
		show(a);
		System.out.println();
		System.out.println("--------��ʼ����---------");
		sort(a);
		assert isSorted(a);
		System.out.print("�����:");
		show(a);

	}

}
