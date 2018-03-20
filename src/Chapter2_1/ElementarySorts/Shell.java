package Chapter2_1.ElementarySorts;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Shell extends Example {
	/*希尔排序
	 * 基于插入排序的快速的排序算法
	 * 使数组中任意间隔为h的元素是有序的。
	 * 对于h的选择为--》数组的长度a/3+1,每次递减为h/3一直到1。
	 * 当h=1的时候已经等于插入排序了。
	 * */
	public static void sort(Comparable[] a) {
		int N =  a.length;
		int h=1;
		while(h<N/3) {
			h=3*h+1;
		}
		while(h>=1) {
			
			//这一个循环作为在本次h间隔里，i从h开始，每次完成后往后加一，直到把后面的数遍历完
			//是往后看的
			for (int i = h; i < N; i++) {
				
				//j是从i开始的，这个循环里如果i超过了h，即当j>=h里，可以不止比较一次。
				//是往前看的
				for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h) {
					exch(a,j,j-h);//交换的元素是a[j]和a[j-h]，往前看
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
