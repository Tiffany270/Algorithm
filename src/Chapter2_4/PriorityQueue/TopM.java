package Chapter2_4.PriorityQueue;

import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TopM {
	/*
	 * ֻ��һ�����ȶ��е����� ��ӡ�����������M��
	 * ����һ����������Ϊ�������ȶ��У������ȶ��еĴ�С����Mʱ��ɾ����������С��Ԫ�ء�
	 * ������󣬷���ջ�У��������ջ�Եߵ����ǵ�˳��
	 * �������ջ��
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
