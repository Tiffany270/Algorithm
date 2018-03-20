package Chapter1_3.QueuesAndStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {

	/*
	 * �򵥵ؼ����׼�����е�����doubleֵ��ƽ��ֵ��������׼�� ����Щ�����У����ļ���˳��ͽ���޹�
	 */

	public static void main(String[] args) {
		Bag<Double> numbers = new Bag<Double>();
		while (!StdIn.isEmpty()) {
			numbers.add(StdIn.readDouble());
		}
		int N = numbers.size();
		double sum = 0.0;
		for (Double x : numbers) {//�����õ����﷨�Ǻ�Bagʵ�ֵĵ������й�
			sum += x;
		}
		double mean = sum / N;

		sum = 0.0;
		for (Double x : numbers) {
			sum += (x - mean) * (x - mean);

		}
		double std = Math.sqrt(sum / (N - 1));
		StdOut.println(mean);
		StdOut.println(std);
		
	}

}
