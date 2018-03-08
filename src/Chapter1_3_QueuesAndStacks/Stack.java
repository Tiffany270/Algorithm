package Chapter1_3_QueuesAndStacks;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {
	/*
	 * ����ʵ�ֵ�ջ
	 */

	private Node first;// head
	private int N;// number of elements

	private class Node {
		Item item;
		Node next;
	}

	
	
	// ���Ԫ��
	void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;

	}

	// ɾ�������ӵ�Ԫ��
	Item pop() {

		Item item = first.item;
		first = first.next;
		N--;
		return item;

	}

	// �ж��Ƿ�Ϊ��
	boolean isEmpty() {
		return first == null;
	}

	// ջ��Ԫ�ص�����
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
		// Ҫ����ѭ��������ֶ�ֹͣ
		StdOut.print("Left " + stack.N + " on stack");

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
