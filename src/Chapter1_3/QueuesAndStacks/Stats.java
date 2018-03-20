package Chapter1_3.QueuesAndStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {

	/*
	 * 简单地计算标准输入中的所有double值得平均值和样本标准差 在这些计算中，数的计算顺序和结果无关
	 */

	public static void main(String[] args) {
		Bag<Double> numbers = new Bag<Double>();
		while (!StdIn.isEmpty()) {
			numbers.add(StdIn.readDouble());
		}
		int N = numbers.size();
		double sum = 0.0;
		for (Double x : numbers) {//这里用到的语法糖和Bag实现的迭代器有关
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
