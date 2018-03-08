package Chapter1_3_QueuesAndStacks;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

	private Node first;
	private int size;

	private class Node {
		Node next;
		Item item;
	}

	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		
		size++;

	}
	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/*添加了迭代器就可以忽略类型使得即可变得可迭代*/
	private class ListIterator implements Iterator<Item> {

		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
		}

	}

}
