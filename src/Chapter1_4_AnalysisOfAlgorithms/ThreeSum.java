package Chapter1_4_AnalysisOfAlgorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
	
	public static int count(int[] a) {
		//ͳ�ƺ�Ϊ0��Ԫ�����������������
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					if(a[i]+a[j]+a[k]==0) {
						cnt++;
					}
					
				}
				
			}
			
		}
		return cnt;
		
		
	}
	
	

	public static void main(String[] args) {
		
		try {
			
			int[] a = StdIn.readAllInts();
			StdOut.println(count(a));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("����Խ���ˣ�����");
		}
		

	}

}
