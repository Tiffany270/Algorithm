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
	 * 从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整
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
			} else {// 否则就是右了
				if (!stack.isEmpty()) {//防止最后一个是右括号但是栈是空的
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
		if (!stack.isEmpty())// 如果还没有匹配完
			return false;
		return true;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
