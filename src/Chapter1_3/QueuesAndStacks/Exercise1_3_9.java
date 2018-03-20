package Chapter1_3.QueuesAndStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_9 {
	/*
	 * 这个题没有做出来……
	 * I can't figure out this exercise,
	 * If u have any good solution,please let me know.
	 * 从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式
	 */

	public static void main(String[] args) {

		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		String str = null;
		String result = null;

		while (!StdIn.isEmpty()) {

			String s = StdIn.readString();
			System.out.println("s="+s);
			if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("*")) {
				ops.push(s);
			} else if (s.equals("/")) {
				ops.push(s);
			}

			else if (s.equals(")")) {
				String op = ops.pop();
				String v1 = vals.pop();
				String v2 = vals.pop();
				System.out.println("op" + op);
				System.out.println("v1=" + v1);
				System.out.println("v2=" + v2);

				if (op.equals("+")) {
					str = "(" + v1 + op + v2 + ")";
				} else if (op.equals("-")) {
					str = "(" + v1 + op + v2 + ")";
				} else if (op.equals("*")) {
					str = "(" + v1 + op + v2 + ")";
				} else if (op.equals("/")) {
					str = "(" + v1 + op + v2 + ")";
				}
				vals.push(str);

			} else {
				vals.push(s);
			}

		}
		while(!ops.isEmpty()) {
			result = vals.pop()+ops.pop()+vals.pop();}
		// 写数据文件的时候记得空格才能读取下一个
		StdOut.print(result);

	}

}
