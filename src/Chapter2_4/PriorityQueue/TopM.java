package Chapter2_4.PriorityQueue;

import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TopM {
	/*
	 * 只是一个优先队列的用例 打印输出流中最大的M行
	 * 构造一个用数字作为键的优先队列，当优先队列的大小超过M时就删除掉其中最小的元素。
	 * 处理完后，放入栈中，遍历这个栈以颠倒他们的顺序。
	 * 遍历这个栈。
	 * 
	 */

	public static void main(String[] args) {

		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ<Transaction>(M + 1);
		
		while (StdIn.hasNextLine()) {

			pq.insert(new Transaction(StdIn.readLine()));
			if (pq.size() > M) {

				pq.delMax();
			}
			Stack<Transaction> stack = new Stack<>();
			while (!pq.isEmpaty()) {
				stack.push(pq.delMax());
			}

			for (Transaction t : stack) {
				StdOut.print(t);
			}
		}
	}

}
