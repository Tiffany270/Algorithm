package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.In;

public class Insertion extends Example {
	/*��������
	 * ֻ�ύ�����ڵ�Ԫ��
	 * �������� Ϊ�˸�Ҫ�����Ԫ���ڳ��ռ䣬��Ҫ����������Ԫ���ڲ���֮ǰ�������ƶ�һλ
	 * ��ǰ������ߵ�����Ԫ�ض�������ģ����ǵ���������������Ҷ�ʱ���������������ˡ�
	 */

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
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
