package Chapter1_3.QueuesAndStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_1 {
	/*
	 * Add a method isFull() 添加又一个方法isFull()
	 */

	private String[] arr;
	private int size;
	private int cap;

	public Exercise1_3_1(int cap) {
		this.cap = cap;
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

	public boolean isFull() {
		return size == cap;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Exercise1_3_1 stack = new Exercise1_3_1(3);

		while (!stack.isFull()) {
			if (!StdIn.isEmpty()) {
				String item = StdIn.readString();
				if (!item.equals("-")) {
					stack.push(item);
				}
			}

		}
		StdOut.print(stack.size + " 已经栈满");

	}

}
