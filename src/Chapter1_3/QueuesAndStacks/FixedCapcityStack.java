package Chapter1_3.QueuesAndStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapcityStack<Item> {
	/*
	 * ��ʾ���Ͷ���ջ
	 */
	
	private Item[] arr;
	private int size;

	@SuppressWarnings("unchecked")
	public FixedCapcityStack(int cap) {
		arr = (Item[]) new Object[cap];
	}

	public void push(Item item) {
		arr[size++] = item;
	}

	public Item pop() {
		return arr[--size];
	}

	public boolean isEmpty() {
		return size==0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		
		FixedCapcityStack<String> stack = new FixedCapcityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				stack.push(item);
			} 
			else if (!stack.isEmpty()) {
				StdOut.print(stack.pop() + " ");
				
			}

		}
		//Ҫ����ѭ��������ֶ�ֹͣ
		StdOut.print("Left " + stack.size + " on stack");

	}

	

}
