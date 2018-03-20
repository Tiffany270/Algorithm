package Chapter1_3.QueuesAndStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Reverse {
	/*
	 * 把标准输入中的所有整数逆序排列，无需要预先知道整数的多少
	 */

	

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		while(!StdIn.isEmpty()) {
			stack.push(StdIn.readInt());
		}
		
		for (int i : stack) {
			StdOut.println(i);
		}
		
	}

}
