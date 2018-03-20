package Chapter1_3.QueuesAndStacks;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Exercise1_3_4_Parentheses<Item> implements Iterable<Item> {
	/*
	 * Write a stack client Parentheses.java that reads in sequence of left and
	 * right parentheses, braces, and brackets from standard input and uses a stack
	 * to determine whether the sequence is properly balanced. For example, your
	 * program should print true for [()]{}{[()()]()} and false for [(]).
	 * 
	 * �ӱ�׼�����ж�ȡһ���ı�����ʹ��ջ�ж����е������Ƿ��������
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

		System.out.println(parentheses());
	}

	public static boolean parentheses() {
		Exercise1_3_4_Parentheses<String> stack = new Exercise1_3_4_Parentheses<String>();
		while (!StdIn.isEmpty()) {
			String right = StdIn.readString();
			System.out.println("all" + right);
			if (right.equals("[") || right.equals("{") || right.equals("(")) {
				stack.push(right);
				System.out.println("right" + right);
				continue;
			} else {// �����������
				if (!stack.isEmpty()) {//��ֹ���һ���������ŵ���ջ�ǿյ�
					String left = stack.pop();
					System.out.println("left" + left);
					if (right.equals("}")) {
						if (!left.equals("{"))
							return false;
					} else if (right.equals("]")) {
						if (!left.equals("["))
							return false;
					} else if (right.equals(")")) {
						if (!left.equals("("))
							return false;
					}
				} else {
					return false;
				}
			}

		}
		if (!stack.isEmpty())// �����û��ƥ����
			return false;
		return true;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
