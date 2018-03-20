package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Shell extends Example {
	/*ϣ������
	 * ���ڲ�������Ŀ��ٵ������㷨
	 * ʹ������������Ϊh��Ԫ��������ġ�
	 * ����h��ѡ��Ϊ--������ĳ���a/3+1,ÿ�εݼ�Ϊh/3һֱ��1��
	 * ��h=1��ʱ���Ѿ����ڲ��������ˡ�
	 * */
	public static void sort(Comparable[] a) {
		int N =  a.length;
		int h=1;
		while(h<N/3) {
			h=3*h+1;
		}
		while(h>=1) {
			
			//��һ��ѭ����Ϊ�ڱ���h����i��h��ʼ��ÿ����ɺ������һ��ֱ���Ѻ������������
			//�����󿴵�
			for (int i = h; i < N; i++) {
				
				//j�Ǵ�i��ʼ�ģ����ѭ�������i������h������j>=h����Բ�ֹ�Ƚ�һ�Ρ�
				//����ǰ����
				for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h) {
					exch(a,j,j-h);//������Ԫ����a[j]��a[j-h]����ǰ��
				}
			}
			h=h/3;
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
		
	}

}
