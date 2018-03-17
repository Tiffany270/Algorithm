package Chapter1_3_QueuesAndStacks;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_7<Item> implements Iterable<Item> {
	/*
	 * Add a method peek to Stack.java that returns the most recently inserted item
	 * on the stack (without popping it).
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
	
	Item peek() {
		
		return first.item;
		
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

		Exercise1_3_7<String> stack = new Exercise1_3_7<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				stack.push(item);
			} else if (!stack.isEmpty()) {
				StdOut.print(stack.pop() + " ");

			}

		}
		// Ҫ����ѭ��������ֶ�ֹͣ
		System.out.println();
		StdOut.println("peek is "+"'"+stack.peek()+"'");
		StdOut.print("Left " + stack.N + " on stack");

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
