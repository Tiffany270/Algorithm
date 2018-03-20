package Chapter1_3.QueuesAndStacks;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayOfStack<Item> {
	/*
	 * 可调整数组大小的栈 push时如果没有多余空间，数组翻倍 pop时如果栈满足只有小于1/4时，数组缩减1/2
	 */
	private Item[] arr;
	private int size;
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	
	//支持后进先出的迭代
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
		
		//避免在迭代中穿插能够修改数据结构的操作，此方法总为空
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
		arr[size] = null;// 将被弹出的数组元素值设置为空避免thrashing
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
		//要跳出循环请键盘手动停止
		StdOut.print("Left " + stack.size + " on stack");

	}


}
