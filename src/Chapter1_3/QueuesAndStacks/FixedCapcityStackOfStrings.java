package Chapter1_3.QueuesAndStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapcityStackOfStrings {
	/*
	 * 定容栈，只能使用String类型
	 */

	private String[] arr;
	private int size;

	public FixedCapcityStackOfStrings(int cap) {
		arr = new String[cap];
	}

	public void push(String item) {
		arr[size++] = item;
	}

	public String pop() {
		return arr[--size];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
	
	public boolean isFull() {
		return true;
	}

	public static void main(String[] args) {
		FixedCapcityStackOfStrings stack = new FixedCapcityStackOfStrings(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				stack.push(item);
			} 
			else if (!stack.isEmpty()) {
				StdOut.print(stack.pop() + " ");
				
			}

		}
		//要跳出循环请键盘手动停止
		StdOut.print("还剩" + stack.size + "在栈�?");

	}

}
