package Chapter1_3_QueuesAndStacks;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {
	/*
	 * 链表实现的栈
	 */

	private Node first;// head
	private int N;// number of elements

	private class Node {
		Item item;
		Node next;
	}

	
	
	// 添加元素
	void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;

	}

	// 删除最近添加的元素
	Item pop() {

		Item item = first.item;
		first = first.next;
		N--;
		return item;

	}

	// 判断是否为空
	boolean isEmpty() {
		return first == null;
	}

	// 栈中元素的数量
	int size() {
		return N;
	}

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				stack.push(item);
			} else if (!stack.isEmpty()) {
				StdOut.print(stack.pop() + " ");

			}

		}
		// 要跳出循环请键盘手动停止
		StdOut.print("Left " + stack.N + " on stack");

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
