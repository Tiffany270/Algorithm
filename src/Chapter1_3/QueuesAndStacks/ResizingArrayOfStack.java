package Chapter1_3.QueuesAndStacks;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayOfStack<Item> {
	/*
	 * �ɵ��������С��ջ pushʱ���û�ж���ռ䣬���鷭�� popʱ���ջ����ֻ��С��1/4ʱ����������1/2
	 */
	private Item[] arr;
	private int size;
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	
	//֧�ֺ���ȳ��ĵ���
	private class ReverseArrayIterator implements Iterator<Item>{

		private int i = size;
		
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return arr[--i];
		}
		
		//�����ڵ����д����ܹ��޸����ݽṹ�Ĳ������˷�����Ϊ��
		public void remove() {}
		
	}

	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];
			arr = temp;
		}

	}

	@SuppressWarnings("unchecked")
	public ResizingArrayOfStack(int cap) {
		arr = (Item[]) new Object[cap];
	}

	public void push(Item item) {
		if (size == arr.length) {
			resize(2 * arr.length);
		}
		arr[size++] = item;
	}

	public Item pop() {
		Item item = arr[--size];
		arr[size] = null;// ��������������Ԫ��ֵ����Ϊ�ձ���thrashing
		if (size > 0 && size == arr.length / 4) {
			resize(arr.length / 2);
		}
		return item;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		ResizingArrayOfStack<String> stack = new ResizingArrayOfStack<String>(100);
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
